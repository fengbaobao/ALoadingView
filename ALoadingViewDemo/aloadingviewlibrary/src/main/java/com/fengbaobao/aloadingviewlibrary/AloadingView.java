package com.fengbaobao.aloadingviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author wqr
 * @des Loading view
 */
public class AloadingView extends FrameLayout implements IAloadingViewUtils {

    private int emptyView, errorView, loadingView, contentView, animation;

    protected OnClickListener onRetryClickListener;
    protected OnClickListener onEmptyClickListener;

    private IAloadingViewBuilder emptyViewBuilder;
    private IAloadingViewBuilder errorViewBuilder;
    private AnimationAloadingViewBuilder animationViewBuilder;

    private IAloadingViewUtils mAloadingViewUtils;

    public AloadingView(Context context) {
        this(context, null);
    }

    public AloadingView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AloadingView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AloadingView, 0, 0);
        try {

            emptyView = a.getResourceId(R.styleable.AloadingView_emptyView, getEmptyViewLayout());
            errorView = a.getResourceId(R.styleable.AloadingView_errorView, getErrorViewLayout());
            loadingView = a.getResourceId(R.styleable.AloadingView_loadingView, getLoadingViewLayout());

            contentView = a.getResourceId(R.styleable.AloadingView_contentView, 0);

            animation = a.getResourceId(R.styleable.AloadingView_animation, 0);

            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(emptyView, this, true);  // 0
            inflater.inflate(errorView, this, true); // 1
            inflater.inflate(loadingView, this, true); //2

            emptyViewBuilder = new AloadingViewBuilder(this, getChildAt(0));
            errorViewBuilder = new AloadingViewBuilder(this, getChildAt(1));
            animationViewBuilder = new AnimationAloadingViewBuilder(this, getChildAt(2));

            mAloadingViewUtils = new AloadingViewUtils(this);

            init();

        } finally {
            a.recycle();
        }
    }

    protected void init() {

//        if (emptyView == getEmptyViewLayout()) {
//            emptyViewBuilder.setText(R.id.aload_info, R.string.has_no_data)
//                    .setImg(R.id.aload_icon, R.drawable.data_empty);
//        }
//
//        if (errorView == getErrorViewLayout()) {
//            errorViewBuilder.setImg(R.id.aload_icon, R.drawable.data_empty)
//                    .setText(R.id.aload_info, R.string.error_label)
//                    .setText(R.id.btn_retry, R.string.reload_label);
//        }

        if (emptyView == getEmptyViewLayout()) {

            if (ResourceUtils.checkResourceID("emptyClickView")) {
                emptyViewBuilder.setOnClickViewIds(R.id.emptyClickView);
            }
        }


        if (errorView == getErrorViewLayout()) {

            if (ResourceUtils.checkResourceID("btn_retry")) {
                errorViewBuilder.setOnClickViewIds(R.id.btn_retry);
            }
        }

        if (loadingView == getLoadingViewLayout()) {
            if (ResourceUtils.checkResourceID("aload_icon") && ResourceUtils.checkResourceAnim("aloading")) {
                animationViewBuilder.initAnimationView(R.id.aload_icon, (animation == 0) ? R.anim.aloading : animation);
            }
        }

    }

    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();

        for (int i = 0; i < getChildCount() - 1; i++) {
            getChildAt(i).setVisibility(GONE);
        }

        View clickView;

        clickView = findViewById(R.id.btn_retry);
        if (null != clickView) {
            clickView.setClickable(true);
            clickView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != onEmptyClickListener) {
                        onEmptyClickListener.onClick(v);
                    }
                }
            });

        }

        if (null != clickView) {
            clickView = findViewById(R.id.btn_retry);
            clickView.setOnClickListener(
                    new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (null != onRetryClickListener) {
                                onRetryClickListener.onClick(v);
                            }
                        }
                    });
            clickView.setClickable(true);
        }
    }

    public void setOnRetryClickListener(OnClickListener onRetryClickListener) {

        this.onRetryClickListener = onRetryClickListener;
        getErrorViewBuilder().setOnDefaultClickListener(onRetryClickListener);
    }

    public void setOnEmptyClickListener(OnClickListener onEmptyClickListener) {

        this.onEmptyClickListener = onEmptyClickListener;
        getEmptyViewBuilder().setOnDefaultClickListener(onEmptyClickListener);
    }

    /**
     * 显示默认空页面
     */
    @Override
    public void showEmpty() {

        if (null != mAloadingViewUtils) {
            mAloadingViewUtils.showEmpty();
        }
    }

    /**
     * 显示指定内容的空页面
     *
     * @param info
     * @param resId
     */
    public void showEmpty(String info, int resId) {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 0) {
                setEmptyInfoCostom(info, resId, child);
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    /**
     * 显示错误页
     */
    @Override
    public void showError() {

        if (null != mAloadingViewUtils) {
            mAloadingViewUtils.showError();
        }
    }

    /**
     * 显示错误页，指定内容
     *
     * @param info
     * @param resId
     */
    public void showError(String info, int resId) {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 1) {
                setEmptyInfoCostom(info, resId, child);
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    /**
     * 显示错误页，指定内容、是否显示重试按钮
     *
     * @param info
     * @param resId
     * @param showRetryButton
     */
    public void showError(String info, int resId, boolean showRetryButton) {
        showError(info, resId);
        View retry = findViewById(R.id.btn_retry);
        if (retry != null) retry.setVisibility(GONE);
    }

    /**
     * 显示加载页
     */
    @Override
    public void showLoading() {

        if (null != mAloadingViewUtils) {
            mAloadingViewUtils.showLoading();
        }
    }

    /**
     * 显示加载页，指定内容
     *
     * @param info
     * @param resId
     */
    public void showLoading(String info, int resId) {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 2) {
                child.setVisibility(VISIBLE);
                ImageView iv = (ImageView) child.findViewById(R.id.aload_icon);
                if (iv != null)
                    startAnimation(iv);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    /**
     * 显示 contentView
     */
    public void showContent() {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 3 || child.getId() == contentView) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    private void setEmptyInfoCostom(String info, int resId, View child) {
        if (!TextUtils.isEmpty(info)) {
            TextView tv = (TextView) child.findViewById(R.id.aload_info);
            if (tv != null)
                tv.setText(info);
        }
        if (resId > 0) {
            ImageView iv = (ImageView) child.findViewById(R.id.aload_icon);
            if (iv != null)
                iv.setImageResource(resId);
        }
    }

    private void startAnimation(ImageView iv) {
        AnimationDrawable animDrawable = (AnimationDrawable) iv.getDrawable();
        if (null == animDrawable) {
            iv.setImageResource((animation == 0) ? R.anim.aloading : animation);
            animDrawable = (AnimationDrawable) iv.getDrawable();
        }
        iv.clearAnimation();
        animDrawable.start();
    }

    protected int getEmptyViewLayout() {
        return R.layout.aloading_empty_view;
    }

    protected int getErrorViewLayout() {
        return R.layout.aloading_error_view;
    }

    protected int getLoadingViewLayout() {
        return R.layout.aloading_view;
    }

    public IAloadingViewBuilder getEmptyViewBuilder() {
        return emptyViewBuilder;
    }

    public IAloadingViewBuilder getErrorViewBuilder() {
        return errorViewBuilder;
    }

    public AnimationAloadingViewBuilder getAnimationViewBuilder() {
        return animationViewBuilder;
    }

}
