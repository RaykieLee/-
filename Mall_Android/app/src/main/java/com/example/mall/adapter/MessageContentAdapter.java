package com.example.mall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mall.R;
import com.example.mall.bean.MessageListBean;
import com.xuexiang.xui.widget.imageview.RadiusImageView;
import com.xuexiang.xui.widget.textview.badge.BadgeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.xuexiang.xui.XUI.getContext;

public class MessageContentAdapter extends RecyclerView.Adapter<MessageContentAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";
    private onRecyclerViewListener onRecyclerViewListener;
    private List<MessageListBean> mList;
    private Context context;

    public MessageContentAdapter(Context context, List<MessageListBean> mList) {
        this.context = context;
        this.mList = mList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder viewHolder;
        View inflate = LayoutInflater.from(context).inflate(R.layout.message_item, parent, false);
        viewHolder = new MyViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MessageListBean messageListBean = mList.get(position);
        holder.name.setText(messageListBean.getName());
        holder.data.setText(messageListBean.getData());
        holder.messageContent.setText(messageListBean.getMessageContent());
        Log.d(TAG, "onBindViewHolder: " + messageListBean.getData());
        holder.data.setText(messageListBean.getData());
        Glide.with(holder.itemView)
                .load(messageListBean.getMessageImage())
                .into(holder.messageImage);
        new BadgeView(getContext()).bindTarget(holder.messageNum).setShowShadow(false).setBadgeNumber(5);
        holder.messageLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnRecyclerViewListener(MessageContentAdapter.onRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    interface onRecyclerViewListener {
        void editHeadIcon(int position);

        void deleteInfo(int position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.message_image)
        RadiusImageView messageImage;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.message_content)
        TextView messageContent;
        @BindView(R.id.data)
        TextView data;
        @BindView(R.id.message_num)
        View messageNum;
        @BindView(R.id.message_linear)
        LinearLayout messageLinear;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
