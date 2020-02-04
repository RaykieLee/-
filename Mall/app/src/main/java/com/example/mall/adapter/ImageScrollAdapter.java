package com.example.mall.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import  android.support.v4.view.ViewPager;
import  android.support.v4.view.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.mall.R;
import com.example.mall.bean.CommonResult;
import com.example.mall.bean.Goods;
import com.example.mall.util.HttpUtil;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public class ImageScrollAdapter extends PagerAdapter  {
    private Context mContext;
    private List<String> imags;
    private Integer mChildCount;

    public ImageScrollAdapter(Context context, List<String> imags) {
        mContext = context;
        this.imags = imags;
    }

    @Override
    public int getCount() {
        return imags.size();
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        final  ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Log.d(TAG, "instantiateItem: "+imags.get(position));
        Glide.with(this.mContext)
                .load(imags.get(position))
                .into(imageView);
        view.addView(imageView);
        return imageView;
    }
    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        Log.d(TAG, "instantiateItem: "+imags.get(0));


        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (mChildCount > 0) {
            mChildCount--;
            return POSITION_NONE;
        }

        return super.getItemPosition(object);
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
