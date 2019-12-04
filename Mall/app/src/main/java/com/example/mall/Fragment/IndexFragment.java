package com.example.mall.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.mall.DemoDataProvider;
import com.example.mall.MainActivity;
import com.example.mall.R;
import com.example.mall.SearchActivity;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.banner.widget.banner.SimpleImageBanner;
import com.xuexiang.xui.widget.layout.XUILinearLayout;
import com.xuexiang.xui.widget.textview.MarqueeTextView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class IndexFragment extends Fragment {
    @BindView(R.id.sib_the_most_comlex_usage)
    SimpleImageBanner rib_simple_usage;
    Unbinder unbinder;
    @BindView(R.id.tv_marquee)
    MarqueeTextView tvMarquee;
    @BindView(R.id.new_commodity)
    LinearLayout newCommodity;
    @BindView(R.id.new_commodity_linner)
    LinearLayout new_commodity_linner;

    @BindView(R.id.search)
    XUILinearLayout search;

    private List<BannerItem> mData;

    private View view;//得到碎片对应的布局文件,方便后续使用

    //记住一定要重写onCreateView方法
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.indexfragment, container, false);//得到对应的布局文件
        unbinder = ButterKnife.bind(this, view);
        inData();
        initView();
        return view;
    }

    private void initView() {
        initnewCommodityGrid();
        search.setRadius(50);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initnewCommodityGrid() {
        //newCommodityGrid.setRowCount(1);
        // newCommodityGrid.setColumnCount(1);
        View Commodityview = LayoutInflater.from(getActivity()).inflate(R.layout.commodity, null);
        new_commodity_linner.addView(Commodityview);
        ImageView imageView = Commodityview.findViewById(R.id.item_img);
        LinearLayout linearLayout = Commodityview.findViewById(R.id.item_view);
        Glide.with(Commodityview)
                .load("https://img.alicdn.com/simba/img/TB1Rt0UoAY2gK0jSZFgSuw5OFXa.jpg")
                .into(imageView);
        Commodityview = LayoutInflater.from(getActivity()).inflate(R.layout.commodity, null);
        imageView = Commodityview.findViewById(R.id.item_img);
        Glide.with(Commodityview)
                .load("https://img.alicdn.com/simba/img/TB1Rt0UoAY2gK0jSZFgSuw5OFXa.jpg")
                .into(imageView);
        new_commodity_linner.addView(Commodityview);
    }

    private void inData() {
        mData = DemoDataProvider.getBannerList();
        rib_simple_usage.setSource(mData).startScroll();
        final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
//        tvMarquee.setOnMarqueeListener(new MarqueeTextView.OnMarqueeListener() {
//            @Override
//            public DisplayEntity onStartMarquee(DisplayEntity displayMsg, int index) {
//                if (displayMsg.toString().equals("离离原上草，一岁一枯荣。")) {
//                    return null;
//                } else {
//                   // XToastUtils.toast("开始滚动：" + displayMsg.toString());
//                    return displayMsg;
//                }
//            }
//
//            @Override
//            public List<DisplayEntity> onMarqueeFinished(List<DisplayEntity> displayDatas) {
//                //XToastUtils.toast("一轮滚动完毕！");
//                return displayDatas;
//            }
//        });

        tvMarquee.startSimpleRoll(datas);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
