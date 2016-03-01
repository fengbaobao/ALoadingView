package com.fengbaobao.aloadingviewlibrary;

import android.view.View;

/**
 * Created by dreamtang860 on 2/24/16.
 */
public interface IAloadingViewBuilder {

    public IAloadingViewBuilder setImg(int id, int imgID);

    public IAloadingViewBuilder setText(int id, int strID);

    public IAloadingViewBuilder setOnClickListener(int id, View.OnClickListener mOnClickListener);

    public IAloadingViewBuilder setOnDefaultClickListener(View.OnClickListener onDefaultClickListener);

    public IAloadingViewBuilder setOnClickViewIds(int... ids);

    public IAloadingViewBuilder show(int id);

    public IAloadingViewBuilder hide(int id);

    public AloadingView build();

}
