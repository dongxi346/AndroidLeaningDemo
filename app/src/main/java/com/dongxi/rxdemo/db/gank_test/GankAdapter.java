package com.dongxi.rxdemo.db.gank_test;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dongxi.rxdemo.global.BaseApplication;
import com.dongxi.rxdemo.utils.recyclerview.CommonAdapter;
import com.dongxi.rxdemo.utils.recyclerview.CommonViewHolder;
import com.dongxi.rxdemo.R;

import java.util.List;

/**
 * Created by Administrator on 2017/10/5.
 */

public class GankAdapter extends CommonAdapter<ResultsEntity> {
    public GankAdapter(Context context, int layoutId, List<ResultsEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void onBind(CommonViewHolder holder, ResultsEntity resultsBean, int position) {

        ImageView img = holder.getView(R.id.img_gank) ;
        TextView desc = holder.getView(R.id.tv_desc_gank) ;

        desc.setText(resultsBean.getDesc());
        Glide.with(BaseApplication.getApplication()).load(resultsBean.getUrl()).into(img) ;
    }
}
