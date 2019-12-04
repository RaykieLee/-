package com.example.mall;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import com.example.mall.Fragment.IndexFragment;
import com.example.mall.Fragment.MessageFragment;
import com.example.mall.Fragment.ShoppingCart;
import com.example.mall.Fragment.mineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainviewpager)
    ViewPager viewPager;
    @BindView(R.id.mainTab)
    TabLayout tabLayout;
    //    @BindView(R.id.tabicon)
//    ImageView tabicon;
//    @BindView(R.id.tabtext)
//    TextView tabtext;
    private Fragment[] Lfragments = {new IndexFragment(), new ShoppingCart(), new MessageFragment(), new mineFragment()};
    private String[] Ltitles = {"首页", "消息", "购物车", "我的"};
    //未选中图片
    private int[] Limg = {R.mipmap.mall, R.mipmap.shoppingcart, R.mipmap.message, R.mipmap.mall};
    //选中图片
    private int[] Limgn = {R.mipmap.mall, R.mipmap.shoppingcart, R.mipmap.message, R.mipmap.mall};
    //配置默认选中第几项
    private int ItemWhat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(0);
        //设置默认选中页，宏定义
        tabLayout.getTabAt(ItemWhat).select();
        viewPager.setOffscreenPageLimit(3); //设置向左和向右都缓存的页面个数
        //初始化菜单栏显示
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            //寻找到控件
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.icon_view, null);

            LinearLayout mTabView = (LinearLayout) view.findViewById(R.id.item_view);
            TextView mTabText = (TextView) view.findViewById(R.id.item_text);
            ImageView mTabIcon = (ImageView) view.findViewById(R.id.item_img);

            mTabText.setText(Ltitles[i]);
            mTabIcon.setImageResource(Limg[i]);
            //设置不可点击
            // mTabView.setClickable(true);

            //更改选中项样式
            if (i == ItemWhat) {
                mTabIcon.setImageResource(Limgn[i]);
                mTabText.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            }

            //设置样式
            tabLayout.getTabAt(i).setCustomView(view);
        }
        //是否选中监听
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中时进入，改变样式
                ItemSelect(tab);
                //onTabselected方法里面调用了viewPager的setCurrentItem 所以要想自定义OnTabSelectedListener，也加上mViewPager.setCurrentItem(tab.getPosition())就可以了
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中进入，改变样式
                ItemNoSelect(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //重新选中

            }
        });
    }

    //某个项选中，改变其样式
    private void ItemSelect(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView tabText = (TextView) customView.findViewById(R.id.item_text);
        ImageView tabIcon = (ImageView) customView.findViewById(R.id.item_img);
        tabText.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        String stitle = tabText.getText().toString();
        for (int i = 0; i < Ltitles.length; i++) {
            if (Ltitles[i].equals(stitle)) {
                //Toast.makeText(MainActivity.this,"xxx+"+i,Toast.LENGTH_SHORT).show();
                tabIcon.setImageResource(Limgn[i]);
            }
        }
    }

    //某个项非选中，改变其样式
    private void ItemNoSelect(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView tabText = (TextView) customView.findViewById(R.id.item_text);
        ImageView tabIcon = (ImageView) customView.findViewById(R.id.item_img);
        tabText.setTextColor(ContextCompat.getColor(this, R.color.black));
        String stitle = tabText.getText().toString();
        for (int i = 0; i < Ltitles.length; i++) {
            if (Ltitles[i].equals(stitle)) {
                tabIcon.setImageResource(Limg[i]);
            }
        }
    }

    @OnClick(R.id.mainTab)
    public void onViewClicked() {
    }
}
