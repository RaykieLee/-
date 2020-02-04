package com.example.mall.Acticity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.mall.R;
import com.example.mall.adapter.ImageScrollAdapter;
import com.example.mall.bean.CommonResult;
import com.example.mall.bean.Generater;
import com.example.mall.bean.Goods;
import com.example.mall.bean.Goods.GoodsSkuListBean;
import com.example.mall.bean.Param;
import com.example.mall.bean.ShoppingCarDataBean;
import com.example.mall.util.HttpUtil;
import com.example.mall.util.Utils;
import com.example.mall.view.ChoiceParameterDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class GoodsDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llOverlay;
    private ViewPager viewPager;
    private ArrayList<String> pics=new ArrayList<>();
    private TextView tvCurrent;
    private RelativeLayout rlContainer;
    private ImageView ivPic_;
    private TextView tvPrice;
    private ChoiceParameterDialog choiceParameterDialog;
    private Goods goods ;
    private ImageScrollAdapter adapter;
    private TextView tvtitle_;
    private TextView tvsold;
    private TextView store_name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodsdetail);
        llOverlay = (LinearLayout) findViewById(R.id.ll_overlay);
        ivPic_ = (ImageView) findViewById(R.id.iv_pic_);
        viewPager = (ViewPager) findViewById(R.id.advertViewPager);
        tvCurrent = (TextView) findViewById(R.id.tv_current);
        rlContainer = (RelativeLayout) findViewById(R.id.rl_container);
        tvsold = findViewById(R.id.tv_sold);
        tvPrice = (TextView) findViewById(R.id.tv_price);
        tvtitle_ = findViewById(R.id.tv_title_);
        store_name = findViewById(R.id.tv_shop_name);
        findViewById(R.id.rl_parameter_choice).setOnClickListener(this);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.iv_back_).setOnClickListener(this);
        findViewById(R.id.btn_buy).setOnClickListener(this);
        findViewById(R.id.add_shopping_trolley).setOnClickListener(this);
        adapter = new ImageScrollAdapter(this, pics);
        viewPager.setAdapter(adapter);
        initdata();
        dissmissOverlay();
    }

    private void initdata() {
        HttpUtil.getInstence().getGoodsbyid(getIntent().getIntExtra("Goodid",0))      //获取Observable对象
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new Subscriber<CommonResult<Goods>>() {
                    @Override
                    public void onCompleted() {
                        //   mMiniLoadingDialog.dismiss();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("wxlsb", "response=" + e.getMessage());
                        //  mMiniLoadingDialog.dismiss();
                        //请求失败
                    }
                    @Override
                    public void onNext(CommonResult<Goods> commonResult) {

                        //
                        Log.d("onnnnn", "onNext: "+commonResult.getData());

                        goods=commonResult.getData();
                        init();
                        Log.d("onnnnn", "onNext: "+new Gson().toJson(goods));

                        //请求成功
                    }
                });
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Utils.getScreenWidth(this), Utils.getScreenWidth(this));
        rlContainer.setLayoutParams(layoutParams);
        ivPic_.setLayoutParams(layoutParams);
        tvtitle_.setText(goods.getName());
        String priceString = String.valueOf(goods.getPrice()) ;
//        SpannableString spannableString = new SpannableString(priceString);
//        AbsoluteSizeSpan sizeSpan01 = new AbsoluteSizeSpan(12, true);
//        AbsoluteSizeSpan sizeSpan02 = new AbsoluteSizeSpan(36, true);
//        AbsoluteSizeSpan sizeSpan03 = new AbsoluteSizeSpan(14, true);
//        spannableString.setSpan(sizeSpan01, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(sizeSpan02, 1, priceString.length() - 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(sizeSpan03, priceString.length() - 3, priceString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvPrice.setText(String.valueOf(goods.getPrice()));
//        tvPrice.append(spannableString);
//
//        pics = Generater.GeneratePicResId();
//
//        ImageScrollAdapter adapter = new ImageScrollAdapter(this, Generater.GeneratePicResId());
        pics.clear();
        Log.d("AAA", "init: "+goods.getImageid());
        tvsold.setText(tvsold.getText()+""+goods.getSalesvolume());
        store_name.setText(goods.getStore());
        List<String> teamp =new Gson().fromJson(goods.getImageid(), new TypeToken<List<String>>(){}.getType());
        for (String s:teamp
             ) {
            Log.d("AAA", "init: "+s);
            pics.add(s);
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int position) {
                setCurrent(position);
            }
        });
        adapter.notifyDataSetChanged();
        setCurrent(0);
    }

    private void setCurrent(int position) {
        String priceString = position + 1 + "/" + pics.size();
        SpannableString spannableString = new SpannableString(priceString);
        AbsoluteSizeSpan sizeSpan01 = new AbsoluteSizeSpan(18, true);
        AbsoluteSizeSpan sizeSpan02 = new AbsoluteSizeSpan(13, true);
        spannableString.setSpan(sizeSpan01, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan02, 1, priceString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvCurrent.setText("");
        tvCurrent.append(spannableString);
    }

    private void dissmissOverlay() {
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                final ObjectAnimator animator = ObjectAnimator.ofFloat(llOverlay, "alpha", 1.0f, 0);
                animator.setDuration(800);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if (llOverlay != null)
                            llOverlay.setVisibility(View.GONE);
                    }
                });
                animator.start();
            }
        }, 1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_parameter_choice:
            case R.id.btn_buy:
                if(choiceParameterDialog==null){
                    choiceParameterDialog = new ChoiceParameterDialog(this, goods);
                }
                choiceParameterDialog.show();
                choiceParameterDialog.setSelectedListener(new ChoiceParameterDialog.SelectedListener() {
                    @Override
                    public void onSlectedChanged(boolean allSelected, String param) {

                    }

                    @Override
                    public void onComfirm(int count, Goods.GoodsSkuListBean selectedSku, double price) {
                        Log.d("lzx", "onComfirm: "+price);
                    }
                });
                break;
            case R.id.add_shopping_trolley:
                if(choiceParameterDialog==null){
                    choiceParameterDialog = new ChoiceParameterDialog(this, goods);
                }
                choiceParameterDialog.tvConfirm.setBackgroundColor(Color.parseColor("#FF9800"));
               // choiceParameterDialog.tvConfirm.setText("加入购物车");
                choiceParameterDialog.show();
                choiceParameterDialog.setSelectedListener(new ChoiceParameterDialog.SelectedListener() {
                    @Override
                    public void onSlectedChanged(boolean allSelected, String param) {

                    }

                    @Override
                    public void onComfirm(int count, Goods.GoodsSkuListBean selectedSku, double price) {
                        Log.d("lzx", "onComfirm: "+price);
                    }
                });
                break;
            case R.id.iv_back:
            case R.id.iv_back_:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }else {
                    finish();
                }
                break;
        }
    }
}
