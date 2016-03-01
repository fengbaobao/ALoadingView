package com.fengbaobao.aloadingviewlibrary;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

/**
 * Created by dreamtang860 on 2/25/16.
 */
public class AnimationUtils implements IAnimationUtils {

    private ImageView animationImageView;

    private Integer animationResID;

    public AnimationUtils(ImageView animationImageView, Integer animationResID) {

        this.animationImageView = animationImageView;
        this.animationResID = animationResID;
    }

    public void initAnimationRes(int animationResID) {
        this.animationResID = animationResID;
    }

    @Override
    public void startAnimation() {

        if (null == animationImageView) {
//            throw new IllegalAccessError("Function 'initAnimationView' has not been called...");
            return;
        }

        AnimationDrawable animDrawable = (AnimationDrawable) animationImageView.getDrawable();
        if (null == animDrawable) {
            animationImageView.setImageResource(animationResID);
            animDrawable = (AnimationDrawable) animationImageView.getDrawable();
        }

        animationImageView.clearAnimation();

        animDrawable.start();

    }

    @Override
    public void stopAnimation() {

        if (null == animationImageView) {
//            throw new IllegalAccessError("Function 'initAnimationView' has not been called...");
            return;
        }

        AnimationDrawable animDrawable = (AnimationDrawable) animationImageView.getDrawable();
        if (null != animDrawable) {
            animDrawable.stop();
            animationImageView.clearAnimation();
        }

    }

}
