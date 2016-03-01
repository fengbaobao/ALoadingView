package com.fengbaobao.aloadingviewlibrary;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by dreamtang860 on 2/24/16.
 */
public class AnimationAloadingViewBuilder extends AloadingViewBuilder implements IAnimationUtils {

    public IAnimationUtils animationUtils;

    public AnimationAloadingViewBuilder(AloadingView aloadingView, View mDecorateView) {
        super(aloadingView, mDecorateView);
    }

    public void initAnimationView(int animationImageViewID, Integer animationResID) {

        if (null == mDecorateView) {
            throw new IllegalStateException("Decorate view is null here");
        }

        View mView = mDecorateView.findViewById(animationImageViewID);

        animationUtils = new AnimationUtils((ImageView) mView, animationResID);

    }

    @Override
    public void initAnimationRes(int animationResID) {

        if (null != animationUtils) {
            animationUtils.initAnimationRes(animationResID);
        }
    }

    @Override
    public void startAnimation() {

        if (null == animationUtils) {
            return;
        }

        animationUtils.startAnimation();
    }

    @Override
    public void stopAnimation() {

        if (null == animationUtils) {
            return;
        }

        animationUtils.stopAnimation();
    }

}
