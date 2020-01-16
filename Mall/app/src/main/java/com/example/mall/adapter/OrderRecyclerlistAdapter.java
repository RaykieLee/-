package com.example.mall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mall.R;
import com.example.mall.bean.OmsOrder;
import com.example.mall.bean.OmsOrderItem;
import com.xuexiang.xui.widget.button.roundbutton.RoundButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderRecyclerlistAdapter extends RecyclerView.Adapter<OrderRecyclerlistAdapter.OrderViewHolder> {
    private static final String TAG = "MyAdapter";
    public onRecyclerViewListener onRecyclerViewListener;
    private List<OmsOrder> omsOrders;
    private Context context;

    public OrderRecyclerlistAdapter(Context context, List<OmsOrder> omsOrders) {
        this.context = context;
        this.omsOrders = omsOrders;
    }


    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderViewHolder viewHolder;
        View inflate = LayoutInflater.from(context).inflate(R.layout.orderlist_store, parent, false);
        viewHolder = new OrderViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
        OmsOrder omsOrder = omsOrders.get(position);

        for (OmsOrderItem orderItem : omsOrder.getOmsOrderItems()
        ) {
            View view = LayoutInflater.from(context).inflate(R.layout.orderlist_item, null);
            ViewHolder viewHolder = new ViewHolder(view);
//            viewHolder.
        }
//        holder.goods.addView();

//
////        String url=getContext().getApplicationContext().getResources().getString(R.string.api_url)+"/getImage?+"+goods.getImageid();
//        Glide.with(holder.itemView)
//                .load(R.mipmap.goods_pic)
//                .into(holder.itemImg);
//        holder.itemImg.setImageURI( Uri.parse("res:///" + R.mipmap.goods_pic));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onRecyclerViewListener.onclick(position);
//            }
//        });

    }


    @Override
    public int getItemCount() {
        return omsOrders.size();
    }

    public void setOnRecyclerViewListener(OrderRecyclerlistAdapter.onRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    public interface onRecyclerViewListener {
        void onclick(int position);

    }


    static class OrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.store_logo)
        ImageView storeLogo;
        @BindView(R.id.store_name)
        TextView storeName;
        @BindView(R.id.goods)
        LinearLayout goods;
        @BindView(R.id.cancel_order)
        RoundButton cancelOrder;
        @BindView(R.id.pay_order)
        RoundButton payOrder;
        @BindView(R.id.logistics)
        RoundButton logistics;
        @BindView(R.id.appraise)
        RoundButton appraise;

        OrderViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder {
        @BindView(R.id.goods_image)
        ImageView goodsImage;
        @BindView(R.id.goods_name)
        TextView goodsName;
        @BindView(R.id.goods_attr)
        TextView goodsAttr;
        @BindView(R.id.goods_number)
        TextView goodsNumber;
        @BindView(R.id.goods_num)
        TextView goodsNum;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

