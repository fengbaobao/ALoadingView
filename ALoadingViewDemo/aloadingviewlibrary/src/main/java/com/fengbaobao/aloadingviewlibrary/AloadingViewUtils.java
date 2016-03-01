package com.fengbaobao.aloadingviewlibrary;

import android.view.View;

/**
 * Created by dreamtang860 on 2/26/16.
 */
public class AloadingViewUtils implements IAloadingViewUtils {

    private final AloadingView mAloadingView;

    public AloadingViewUtils(AloadingView mAloadingView) {
        this.mAloadingView = mAloadingView;
    }

    @Override
    public void showEmpty() {

        if (null == mAloadingView) {
            return;
        }

        for (int i = 0; i < mAloadingView.getChildCount(); i++) {

            View child = mAloadingView.getChildAt(i);
            if (i == 0) {
                child.setVisibility(View.VISIBLE);
            } else {
                child.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public void showError() {

        if (null == mAloadingView) {
            return;
        }

        for (int i = 0; i < mAloadingView.getChildCount(); i++) {
            View child = mAloadingView.getChildAt(i);
            if (i == 1) {
                child.setVisibility(View.VISIBLE);
            } else {
                child.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void showLoading() {

        for (int i = 0; i < mAloadingView.getChildCount(); i++) {

            View child = mAloadingView.getChildAt(i);

            if (i == 2) {

                child.setVisibility(View.VISIBLE);

                AnimationAloadingViewBuilder mAnimationViewBuilder = mAloadingView.getAnimationViewBuilder();
                if (null != mAnimationViewBuilder) {
                    mAnimationViewBuilder.startAnimation();
                }

            } else {
                child.setVisibility(View.GONE);
            }
        }
    }
}
