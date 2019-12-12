package com.example.mall;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.mall.Api.MyApi;
import com.example.mall.bean.CommonResult;
import com.example.mall.bean.User;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.utils.Utils;
import com.xuexiang.xui.widget.alpha.XUIAlphaButton;
import com.xuexiang.xui.widget.button.roundbutton.RoundButton;
import com.xuexiang.xui.widget.edittext.ClearEditText;
import com.xuexiang.xui.widget.edittext.PasswordEditText;
import com.xuexiang.xui.widget.edittext.ValidatorEditText;
import com.xuexiang.xui.widget.picker.widget.OptionsPickerView;
import com.xuexiang.xui.widget.picker.widget.builder.OptionsPickerBuilder;
import com.xuexiang.xui.widget.picker.widget.listener.OnOptionsSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.xuexiang.xui.XUI.getContext;

public class RegisteActivity extends AppCompatActivity {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.account)
    ClearEditText account;
    @BindView(R.id.password)
    PasswordEditText password;
    @BindView(R.id.password_next)
    PasswordEditText passwordNext;
    @BindView(R.id.name)
    ClearEditText name;
    @BindView(R.id.adress)
    ClearEditText adress;
    @BindView(R.id.phone)
    ValidatorEditText phone;
    @BindView(R.id.btn_sex_picker)
    XUIAlphaButton btnSexPicker;
    @BindView(R.id.registe)
    RoundButton registe;
    private String[] mSexOption;
    private int sexSelectOption = 0;
    private OptionsPickerView pvOptions;
    Retrofit retrofit = new Retrofit.Builder()
            //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
            .baseUrl("http://mymall.free.idcfengye.com")
            .build();
    MyApi apiStores = retrofit.create(MyApi.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        ButterKnife.bind(this);
        initDate();
        initView();
    }


    private void initDate() {
        mSexOption = ResUtils.getStringArray(R.array.sex_option);

    }

    private void initView() {
        showSexPickerView();
    }
    //性別选择
    private void showSexPickerView() {
         pvOptions= new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                btnSexPicker.setText(mSexOption[options1]);
                sexSelectOption = options1;
            }
        })
                .setTitleText("请选择您的性别")
                .setSelectOptions(sexSelectOption)
                .build();
        pvOptions.setPicker(mSexOption);
    }
    @OnClick(R.id.btn_sex_picker)
    public  void  sexonClicked(){
        pvOptions.show();

    }
    @OnClick(R.id.imageView)
    public void onimageClicked() {


    }
    @OnClick(R.id.registe)
    public void onRegisteClicked(final  View view) {
        String accounttext = account.getText().toString().trim();
        String passwordtext =password.getText().toString().trim();
        String nametext =name.getText().toString().trim();
        String sextext =btnSexPicker.getText().toString().trim();
        String tel = phone.getText().toString().trim();
        String adresstext =adress.getText().toString().trim();

        if(accounttext.isEmpty()||passwordtext.isEmpty()||nametext.isEmpty()||sextext.isEmpty()||tel.isEmpty()||adresstext.isEmpty()||!passwordtext.equals(passwordNext.getText().toString().trim())){
            SnackbarUtils.Short(view, "请输入正确的信息").warning().radius(30, 1, Color.GRAY).show();
        }else{
            apiStores.registered(accounttext,passwordtext,nametext,sextext,tel,adresstext,"null")        //获取Observable对象
                    .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                    .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                    .subscribe(new Subscriber<CommonResult>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.i("wxl", "response=" + e.getMessage());

                            //请求失败
                        }

                        @Override
                        public void onNext(CommonResult commonResult) {
                            if(commonResult.getCode()==200){
                                SnackbarUtils.Short(view, commonResult.getMessage())
                                        .confirm()
                                        .radius(30, 0, Color.GREEN)
                                        .show();
                            }else{
                                SnackbarUtils.Short(view, commonResult.getMessage())
                                        .danger()
                                        .radius(30, 1, Color.GRAY)
                                        .show();
                            }
                            Log.i("wxl", "response=" );
                            Log.i("wxl", "response=" + commonResult.getMessage());

                        }
                    });
        }
    }
}
