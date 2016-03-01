package com.fengbaobao.aloadingviewlibrary;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dreamtang860 on 2/24/16.
 */
public class AloadingViewBuilder implements IAloadingViewBuilder {

    protected final AloadingView aloadingView;
    protected final View mDecorateView;
    protected View.OnClickListener onDefaultClickListener;

    public AloadingViewBuilder(AloadingView aloadingView, View mDecorateView) {

        if (null == aloadingView) {
            throw new IllegalArgumentException("AloadingViewBuilder should not be null...");
        }

        if (null == mDecorateView) {
            throw new IllegalArgumentException("Decorate view should not be null...");
        }

        this.aloadingView = aloadingView;
        this.mDecorateView = mDecorateView;
    }

    @Override
    public IAloadingViewBuilder setImg(int id, int imgID) {

        if (null != mDecorateView) {

            View mView = null;

            try {
                mView = mDecorateView.findViewById(id);
            } catch (Throwable t) {
                mView = null;
            }

            if (null != mView && mView instanceof ImageView) {
                ((ImageView) mView).setImageResource(imgID);
            }
        }

        return this;
    }

    @Override
    public IAloadingViewBuilder setText(int id, int strID) {

        if (null != mDecorateView) {

            View mView = null;

            try {
                mView = mDecorateView.findViewById(id);
            } catch (Throwable t) {
                mView = null;
            }

            if (null == mView) {
                return this;
            }

            if (mView instanceof TextView) {
                ((TextView) mView).setText(strID);
            } else if (mView instanceof Button) {
                ((Button) mView).setText(strID);
            }
        }

        return this;
    }

    @Override
    public IAloadingViewBuilder setOnClickListener(int id, View.OnClickListener mOnClickListener) {

        if (null != mDecorateView) {

            View mView = null;

            try {
                mView = mDecorateView.findViewById(id);
            } catch (Exception e) {
                Log.e("lk_test", "setOnClickListener exception...");
                mView = null;
            } catch (Throwable t) {
                Log.e("lk_test", "setOnClickListener Throwable...");
                mView = null;
            }

            if (null == mView) {
                Log.e("lk_test", "click view not found...");
                return this;
            }

            mView.setClickable(true);
            mView.setOnClickListener(mOnClickListener);
        }

        return this;
    }

    @Override
    public IAloadingViewBuilder setOnClickViewIds(int... ids) {

        if (null != mDecorateView) {

            View mView = null;

            try {

                for (int i = 0; null != ids && i < ids.length; i++) {

                    mView = mDecorateView.findViewById(ids[i]);

                    if (null != mView) {

                        mView.setClickable(true);
                        mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (null != onDefaultClickListener) {
                                    onDefaultClickListener.onClick(v);
                                }
                            }
                        });
                    }
                }
            } catch (Exception e) {
                Log.e("lk_test", "setOnClickListener exception...");
                mView = null;
            } catch (Throwable t) {
                Log.e("lk_test", "setOnClickListener Throwable...");
                mView = null;
            }

        }

        return this;
    }

    @Override
    public IAloadingViewBuilder show(int id) {

        if (null != mDecorateView) {

            View mView = null;

            try {
                mView = mDecorateView.findViewById(id);
            } catch (Throwable t) {
                mView = null;
            }

            if (null != mView) {
                mView.setVisibility(View.VISIBLE);
            }
        }

        return this;
    }

    @Override
    public IAloadingViewBuilder hide(int id) {

        if (null != mDecorateView) {

            View mView = null;

            try {
                mView = mDecorateView.findViewById(id);
            } catch (Throwable t) {
                mView = null;
            }

            if (null != mView) {
                mView.setVisibility(View.GONE);
            }
        }

        return this;
    }

    @Override
    public IAloadingViewBuilder setOnDefaultClickListener(View.OnClickListener onDefaultClickListener) {
        this.onDefaultClickListener = onDefaultClickListener;
        return this;
    }

    @Override
    public AloadingView build() {
        return aloadingView;
    }

}
