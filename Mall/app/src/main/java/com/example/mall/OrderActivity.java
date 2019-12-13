package com.example.mall;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mall.bean.CommonResult;
import com.example.mall.bean.OmsOrder;
import com.example.mall.bean.OmsOrderItem;
import com.example.mall.bean.User;
import com.example.mall.util.HttpUtil;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.dialog.MiniLoadingDialog;

import java.math.BigDecimal;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OrderActivity extends AppCompatActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.adress)
    TextView adress;
    @BindView(R.id.userdate)
    LinearLayout userdate;
    @BindView(R.id.post_Order)
    Button postOrder;
    MiniLoadingDialog mMiniLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        mMiniLoadingDialog= WidgetUtils.getMiniLoadingDialog(this,"发送订单中");

    }

    @OnClick(R.id.post_Order)
    public void onViewClicked(final View view) {
        OmsOrder omsOrder = new OmsOrder(new Long(6),new ArrayList<OmsOrderItem>(),new Long(0),"0","00",new BigDecimal(100),0);
        OmsOrderItem omsOrderItem = new OmsOrderItem(new Long(500),new Long(6),"[黑色，60g]",new Long(4),"江门职业技术学院","江崇杰","极有家天猫旗舰店",new BigDecimal(0),99,new Long(0),"heis");
        mMiniLoadingDialog.show();
        omsOrder.getOmsOrderItems().add(omsOrderItem);
        HttpUtil.getInstence().inomsOrder(omsOrder) //获取Observable对象
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new Subscriber<CommonResult>() {
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
                    public void onNext(CommonResult commonResult) {
                        SnackbarUtils.Short(view, commonResult.getMessage())
                                .danger()
                                .radius(30, 1, Color.GRAY)
                                .show();
                        Log.i("wxl", "response=" + commonResult.getMessage());

                    }
                });
    }
}
