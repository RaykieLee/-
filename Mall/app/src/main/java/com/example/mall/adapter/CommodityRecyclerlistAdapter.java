package com.example.mall.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.mall.bean.Goods;
import com.xuexiang.xui.widget.imageview.RadiusImageView;
import com.xuexiang.xui.widget.textview.badge.BadgeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.xuexiang.xui.XUI.getContext;

public class CommodityRecyclerlistAdapter extends RecyclerView.Adapter<CommodityRecyclerlistAdapter.MyViewHolder>  {
    private static final String TAG = "MyAdapter";
    public onRecyclerViewListener onRecyclerViewListener;
    private List<Goods> mList;
    private Context context;

    public CommodityRecyclerlistAdapter(Context context, List<Goods> mList) {
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
        Goods goods = mList.get(position);
        holder.commodityName.setText(goods.getName());
        holder.commodityDescribe.setText(goods.getDetails());
        holder.commodityPrice.setText(String.valueOf(goods.getPrice()));

//        String url=getContext().getApplicationContext().getResources().getString(R.string.api_url)+"/getImage?+"+goods.getImageid();
        Glide.with(holder.itemView)
                .load(R.mipmap.goods_pic)
                .into(holder.itemImg);
        holder.itemImg.setImageURI( Uri.parse("res:///" + R.mipmap.goods_pic));
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
