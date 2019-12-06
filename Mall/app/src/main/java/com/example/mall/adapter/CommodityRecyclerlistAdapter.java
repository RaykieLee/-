package com.example.mall.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mall.R;
import com.example.mall.bean.CommodityBean;
import com.xuexiang.xui.widget.imageview.RadiusImageView;
import com.xuexiang.xui.widget.textview.badge.BadgeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.xuexiang.xui.XUI.getContext;

public class CommodityRecyclerlistAdapter extends RecyclerView.Adapter<CommodityRecyclerlistAdapter.MyViewHolder>  {
    private static final String TAG = "MyAdapter";
    public onRecyclerViewListener onRecyclerViewListener;
    private List<CommodityBean> mList;
    private Context context;

    public CommodityRecyclerlistAdapter(Context context, List<CommodityBean> mList) {
        this.context = context;
        this.mList = mList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder viewHolder;
        View inflate = LayoutInflater.from(context).inflate(R.layout.commodity, parent, false);
        viewHolder = new MyViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        CommodityBean messageListBean = mList.get(position);
        holder.commodityName.setText(messageListBean.getName());
        holder.commodityDescribe.setText(messageListBean.getCommodityContent());
        holder.commodityPrice.setText(messageListBean.getMoney());
        //todo 关于图片加载，建议使用Glide，一个开源的图片加载和缓存处理的第三方框架，这里就不给大家演示了，后续会专门出一篇Glide的使用文章
        Glide.with(holder.itemView)
                .load(messageListBean.getCommodityImage())
                .into(holder.itemImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerViewListener.onclick(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnRecyclerViewListener(CommodityRecyclerlistAdapter.onRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    public  interface onRecyclerViewListener {
        void onclick(int position);

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView itemImg;
        @BindView(R.id.commodity_name)
        TextView commodityName;
        @BindView(R.id.commodity_describe)
        TextView commodityDescribe;
        @BindView(R.id.commodity_price)
        TextView commodityPrice;
        @BindView(R.id.item_view)
        LinearLayout itemView;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
