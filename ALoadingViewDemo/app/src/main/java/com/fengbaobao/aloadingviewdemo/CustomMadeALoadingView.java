package com.fengbaobao.aloadingviewdemo;

import android.content.Context;
import android.util.AttributeSet;

import com.fengbaobao.aloadingviewlibrary.AloadingView;

/**
 * Created by dreamtang860 on 3/1/16.
 */
public class CustomMadeALoadingView extends AloadingView {

    public CustomMadeALoadingView(Context context) {
        super(context);
    }

    public CustomMadeALoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMadeALoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected int getEmptyViewLayout() {
        return R.layout.my_empty_view;
    }

    @Override
    protected void init() {

        super.init();

        getEmptyViewBuilder().setImg(R.id.iv_emptyImg, R.drawable.i_love_u).setText(R.id.tv_emptyTextView, R.string.my_empty_view_textview_label).setText(R.id.bt_emptyButton, R.string.my_empty_view_button_label).setOnClickViewIds(R.id.bt_emptyButton, R.id.tv_emptyTextView);
    }
}
