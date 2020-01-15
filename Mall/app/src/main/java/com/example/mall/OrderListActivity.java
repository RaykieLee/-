package com.example.mall;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mall.Fragment.IndexFragment;
import com.example.mall.Fragment.MessageFragment;
import com.example.mall.Fragment.OrderlistFragment;
import com.example.mall.Fragment.ShoppingCart;
import com.example.mall.Fragment.mineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListActivity extends AppCompatActivity {

    @BindView(R.id.orderTab)
    TabLayout orderTab;

    @BindView(R.id.orderviewPager)
    ViewPager orderviewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        ButterKnife.bind(this);
        OrderlistFragment orderlistFragment = new OrderlistFragment();
         final Fragment[] Lfragments = {orderlistFragment, orderlistFragment,orderlistFragment, orderlistFragment};

        final String[] Ltitles = {"首页", "消息", "购物车", "我的"};
        orderviewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return Lfragments[position];
            }

            @Override
            public int getCount() {
                return Lfragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return Ltitles[position];
            }
        });
        //绑定
        orderTab.setupWithViewPager(orderviewPager);
        orderTab.setSelectedTabIndicatorHeight(0);
        //设置默认选中页，宏定义
        orderTab.getTabAt(0).select();
        orderviewPager.setOffscreenPageLimit(3); //设置向左和向右都缓存的页面个数
    }

}
