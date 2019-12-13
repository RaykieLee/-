package com.example.mall.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mall.R;
import com.example.mall.adapter.MessageRecyclerlistAdapter;
import com.example.mall.bean.MessageListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MessageFragment extends Fragment {


    @BindView(R.id.message_recycler)
    RecyclerView messageRecycler;

    private List<MessageListBean> mList = new ArrayList<>();

    private View view;//得到碎片对应的布局文件,方便后续使用
    Unbinder unbinder;

    //记住一定要重写onCreateView方法
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.messagefragment, container, false);//得到对应的布局文件
        unbinder = ButterKnife.bind(this, view);
        inData();
        initView();
        initRecyclerView();
        return view;
    }

    private void inData() {
        for (int i = 0; i < 30; i++) {

            mList.add(new MessageListBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575741490&di=92ca815588c88488f6bdd9185ab05754&imgtype=jpg&er=1&src=http%3A%2F%2Fwx3.sinaimg.cn%2Fthumb150%2F75f6e7a7gy1fe3j9r0cmpg20dc07db0t.gif", "崇杰小店店", "江崇杰最新商品上线啦！现在购买只需988", "2019/12/1", "1"));
        }
    }

    private void initView() {
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        MessageRecyclerlistAdapter myAdapter = new MessageRecyclerlistAdapter(getContext(), mList);
        messageRecycler.setLayoutManager(linearLayoutManager);
        messageRecycler.setAdapter(myAdapter);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        //messageRecycler.setHasFixedSize(true);
        myAdapter.notifyDataSetChanged();
        //添加Android自带的分割线
        // messageRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // RecyclerView比ListView相比优点在于可定制强，
        // 也正是由于RecyclerView的可定制性太强，好多功能实现都需要自己来写，
        // RecyclerView不像ListView给开发者提供了setOnItemClickListener()方法，但是要实现监听也不难实现，
//        myAdapter.setOnRecyclerViewListener(new MessageRecyclerlistAdapter.onRecyclerViewListener() {
//            @Override
//            public void editHeadIcon(int position) {
//
//            }
//
//            @Override
//            public void deleteInfo(int position) {
//
//            }
//        });
    }

}
