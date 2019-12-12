package com.example.mall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.xuexiang.xui.utils.ResUtils;
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
    @OnClick(R.id.imageView)
    public void onRegisteClicked() {
    }
}
