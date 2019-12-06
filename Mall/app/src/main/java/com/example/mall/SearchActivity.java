package com.example.mall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mall.adapter.CommodityRecyclerlistAdapter;
import com.example.mall.adapter.FlowTagAdapter;
import com.example.mall.adapter.MessageRecyclerlistAdapter;
import com.example.mall.bean.CommodityBean;
import com.example.mall.bean.MessageListBean;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.widget.flowlayout.FlowTagLayout;
import com.xuexiang.xui.widget.layout.XUILinearLayout;
import com.xuexiang.xui.widget.searchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.xuexiang.xui.XUI.getContext;


public class SearchActivity extends AppCompatActivity {

    private List<CommodityBean> mList = new ArrayList<>();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
//        SearchViewFragment  searchViewFragment= new SearchViewFragment();
//        replaceFragment(searchViewFragment);
        initView();
        inRecyclerData();
        initRecyclerView();
    }

    private void initView() {
        initFlowTagLayout();
        initSearchView();
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
                SnackbarUtils.Long(mSearchView, "Query: " + query).show();
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

    private void inRecyclerData() {
        for (int i = 0; i < 30; i++) {
            mList.add(new CommodityBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575741490&di=92ca815588c88488f6bdd9185ab05754&imgtype=jpg&er=1&src=http%3A%2F%2Fwx3.sinaimg.cn%2Fthumb150%2F75f6e7a7gy1fe3j9r0cmpg20dc07db0t.gif", "崇杰写真店", "江崇杰最新写真上线啦！现在购买只需988", "2019/12/1", "1"));
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        CommodityRecyclerlistAdapter myAdapter = new CommodityRecyclerlistAdapter(this, mList);
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
                Intent intent = new Intent(SearchActivity.this,GoodsDetailActivity.class);
                Toast.makeText(getContext(),"dia",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

    private void initFlowTagLayout() {
        FlowTagAdapter tagAdapter = new FlowTagAdapter(this);
        historyFlowlayout.setAdapter(tagAdapter);
        tagAdapter.addTags(ResUtils.getStringArray(R.array.tags_values));
        historyFlowlayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);
//        historyFlowlayout.setOnTagSelectListener(new FlowTagLayout.OnTagSelectListener() {
//            @Override
//            public void onItemSelect(FlowTagLayout parent, int position, List<Integer> selectedList) {
//               // XToastUtils.toast(getSelectedText(parent, selectedList));
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
