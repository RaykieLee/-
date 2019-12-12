package com.example.mall;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mall.Api.MyApi;

import com.example.mall.bean.CommonResult;
import com.example.mall.bean.User;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.button.roundbutton.RoundButton;
import com.xuexiang.xui.widget.dialog.MiniLoadingDialog;
import com.xuexiang.xui.widget.edittext.ClearEditText;
import com.xuexiang.xui.widget.edittext.PasswordEditText;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.account)
    ClearEditText account;
    @BindView(R.id.password)
    PasswordEditText password;
    @BindView(R.id.login)
    RoundButton login;
    @BindView(R.id.registe)
    RoundButton registe;
    MiniLoadingDialog mMiniLoadingDialog ;
    Retrofit retrofit = new Retrofit.Builder()
            //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
            .baseUrl("http://mymall.free.idcfengye.com")
            .build();
    MyApi apiStores = retrofit.create(MyApi.class);
    private String passwordtext;
    private String accounttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mMiniLoadingDialog= WidgetUtils.getMiniLoadingDialog(this,"正在登陆");
        account.setText(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("name", ""));
        password.setText(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("pass", ""));
    }

    @OnClick({R.id.login, R.id.registe})
    public void onViewClicked(final  View view) {
        switch (view.getId()) {
            case R.id.login:
                accounttext = account.getText().toString().trim();
                passwordtext = password.getText().toString().trim();
                if(accounttext.isEmpty()|| passwordtext.isEmpty()){
                    SnackbarUtils.Short(view, "请输入正确的账号或密码").warning().radius(30, 1, Color.GRAY).show();
                }else{
                    mMiniLoadingDialog.show();
                    apiStores.login(accounttext, passwordtext)        //获取Observable对象
                            .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                            .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                            .subscribe(new Subscriber<CommonResult<User>>() {
                                @Override
                                public void onCompleted() {
                                    mMiniLoadingDialog.dismiss();

                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.i("wxl", "response=" + e.getMessage());
                                    mMiniLoadingDialog.dismiss();

                                    //  mMiniLoadingDialog.dismiss();
                                    //请求失败
                                }

                                @Override
                                public void onNext(CommonResult<User> commonResult) {
                                    Log.i("wxl", "response=" + commonResult.getMessage());

                                    if(commonResult.getCode()==200){
                                        SnackbarUtils.Short(view, commonResult.getMessage())
                                                .confirm()
                                                .radius(30, 0, Color.GREEN)
                                                .show();
                                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("name", accounttext).apply();
                                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("pass", passwordtext).apply();
                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));

                                    }else{
                                        SnackbarUtils.Short(view, commonResult.getMessage())
                                                .danger()
                                                .radius(30, 1, Color.GRAY)
                                                .show();
                                    }
                                    Log.i("wxl", "response=" );
                                    //请求成功
                                }
                            });
                }

                break;
            case R.id.registe:
                startActivity(new Intent(LoginActivity.this,RegisteActivity.class));

                break;
        }
    }
}
