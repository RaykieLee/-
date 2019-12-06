package com.example.mall.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import  android.support.v4.view.ViewPager;
import  android.support.v4.view.PagerAdapter;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public class ImageScrollAdapter extends PagerAdapter  {
    private Context mContext;
    private List<Integer> imags;

    public ImageScrollAdapter(Context context, List<Integer> imags) {
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
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(imags.get(position));
        view.addView(imageView);
        return imageView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
