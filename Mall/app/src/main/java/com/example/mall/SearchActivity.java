package com.example.mall;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mall.Acticity.GoodsDetailActivity;
import com.example.mall.adapter.CommodityRecyclerlistAdapter;
import com.example.mall.adapter.FlowTagAdapter;
import com.example.mall.bean.CommonResult;
import com.example.mall.bean.Goods;
import com.example.mall.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.dialog.MiniLoadingDialog;
import com.xuexiang.xui.widget.flowlayout.FlowTagLayout;
import com.xuexiang.xui.widget.layout.XUILinearLayout;
import com.xuexiang.xui.widget.searchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.xuexiang.xui.XUI.getContext;


public class SearchActivity extends AppCompatActivity {

    private List<Goods> mList = new ArrayList<>();
    @BindView(R.id.history_flowlayout)
    FlowTagLayout historyFlowlayout;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    @BindView(R.id.commodity_list)
    RecyclerView commodityList;
    @BindView(R.id.search_image)
    ImageView searchImage;
    @BindView(R.id.search)
    XUILinearLayout search;
    Gson gson = new Gson();
    List<String> history;
    MiniLoadingDialog mMiniLoadingDialog;
    private CommodityRecyclerlistAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
//        SearchViewFragment  searchViewFragment= new SearchViewFragment();
//        replaceFragment(searchViewFragment);
        initView();

    }

    private void initView() {
        mMiniLoadingDialog= WidgetUtils.getMiniLoadingDialog(this,"正在加载商品数据");
        history= (List<String>)gson.fromJson(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("history", null), new TypeToken<List<String>>(){}.getType());
        if(history==null) history=new ArrayList<>();
        initFlowTagLayout(); // 加载历史流标签
        initSearchView();
        initRecyclerView();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchView.showSearch(false);
                search.setVisibility(View.GONE);
                historyFlowlayout.setVisibility(View.GONE);
            }
        });
    }

    private void initSearchView() {
        mSearchView.setVoiceSearch(true);
        mSearchView.setEllipsize(true);
        mSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                history.add(query);
                inRecyclerData(query);
                SnackbarUtils.Long(mSearchView, "Query: " + query).show();
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("history",gson.toJson(history)).apply();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });
        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
                search.setVisibility(View.VISIBLE);
                historyFlowlayout.setVisibility(View.VISIBLE);
            }
        });

        mSearchView.setSubmitOnClick(true);

    }

    private void inRecyclerData(String name) {
//        for (int i = 0; i < 30; i++) {
//            mList.add(new CommodityBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575741490&di=92ca815588c88488f6bdd9185ab05754&imgtype=jpg&er=1&src=http%3A%2F%2Fwx3.sinaimg.cn%2Fthumb150%2F75f6e7a7gy1fe3j9r0cmpg20dc07db0t.gif", "崇杰写真店", "江崇杰最新写真上线啦！现在购买只需988", "2019/12/1", "1"));
//        }
        HttpUtil.getInstence().selectGoodsbyname(name)        //获取Observable对象
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new Subscriber<CommonResult<List<Goods>>>() {
                    @Override
                    public void onCompleted() {
                        mMiniLoadingDialog.dismiss();

                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i("wxl", "response=" + e.getMessage());
                        //  mMiniLoadingDialog.dismiss();
                        //请求失败
                    }

                    @Override
                    public void onNext(CommonResult<List<Goods>> commonResult) {

                        //
                        for (Goods goods:commonResult.getData()
                             ) {
                            mList.add(goods);
                            Log.i("wxl", "response=" +new Gson().toJson(goods));
                        }
                        myAdapter.notifyDataSetChanged();
                        Log.i("wxl", "response=" +mList.size());
                        //请求成功
                    }
                });
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        mList.add(new Goods(1,"A","A",1,"A",1,1,"A",1,new Date()));
//        mList.add(new Goods(1,"A","A",1,"A",1,1,"A",1,new Date()));
//        mList.add(new Goods(1,"A","A",1,"A",1,1,"A",1,new Date()));
        myAdapter = new CommodityRecyclerlistAdapter(this, mList);
        commodityList.setLayoutManager(linearLayoutManager);
        commodityList.setAdapter(myAdapter);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        //messageRecycler.setHasFixedSize(true);
        myAdapter.notifyDataSetChanged();
        //添加Android自带的分割线
        // messageRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // RecyclerView比ListView相比优点在于可定制强，
        // 也正是由于RecyclerView的可定制性太强，好多功能实现都需要自己来写，
        // RecyclerView不像ListView给开发者提供了setOnItemClickListener()方法，但是要实现监听也不难实现，
        myAdapter.setOnRecyclerViewListener(new CommodityRecyclerlistAdapter.onRecyclerViewListener() {
            @Override
            public void onclick(int position) {

                Intent intent = new Intent(SearchActivity.this, GoodsDetailActivity.class);
                Toast.makeText(getContext(),"dia",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

    private void initFlowTagLayout() {
        final FlowTagAdapter tagAdapter = new FlowTagAdapter(this);
        historyFlowlayout.setAdapter(tagAdapter);
        tagAdapter.addTags((List<String>)gson.fromJson(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("history", null), new TypeToken<List<String>>(){}.getType()));
        historyFlowlayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);
        historyFlowlayout.setOnTagSelectListener(new FlowTagLayout.OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, int position, List<Integer> selectedList) {
                inRecyclerData(tagAdapter.getItem(position));
//                SnackbarUtils.Short(historyFlowlayout, tagAdapter.getItem(position))
//                        .danger()
//                        .radius(30, 1, Color.GRAY)
//                        .show();
               // XToastUtils.toast(getSelectedText(parent, selectedList));
            }
        });
//        tagAdapter.setOnListItemListener(new OnListItemListener<String>() {
//            @Override
//            public void onItemClick(int position, String model, int tag) {
//                inRecyclerData(tagAdapter.getItem(position));
//            }
//
//            @Override
//            public void onItemLongClick(int position, String model, int tag) {
//                inRecyclerData(tagAdapter.getItem(position));
//
//            }
//        });
        //tagAdapter.setSelectedPositions(2, 3, 4);
    }
//    private void replaceFragment(SearchViewFragment searchViewFragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.search_fragment, searchViewFragment).commit();
//    }
}
