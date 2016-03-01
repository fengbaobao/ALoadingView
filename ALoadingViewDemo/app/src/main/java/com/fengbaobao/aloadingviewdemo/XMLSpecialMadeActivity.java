package com.fengbaobao.aloadingviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fengbaobao.aloadingviewlibrary.AloadingView;

/**
 * Created by FengBaobao on 3/1/16.
 */
public class XMLSpecialMadeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_xml_special_made_loading_demo);

        Button bt_showLoadingView = (Button) findViewById(R.id.bt_showLoadingView);
        Button bt_showEmptyView = (Button) findViewById(R.id.bt_showEmptyView);
        Button bt_showErrorView = (Button) findViewById(R.id.bt_showErrorView);
        Button bt_showContentView = (Button) findViewById(R.id.bt_showContentView);

        final AloadingView loading_layout = (AloadingView) findViewById(R.id.loading_layout);
        loading_layout.getEmptyViewBuilder().setText(R.id.bt_xmlEmptyButton, R.string.my_xml_empty_view_button_label).setImg(R.id.iv_xmlEmptyImg, R.drawable.i_love_u).setOnClickViewIds(R.id.xmlEmptyClickView).setOnDefaultClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading_layout.showLoading();
            }
        });


        bt_showLoadingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading_layout.showLoading();
            }
        });

        bt_showEmptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading_layout.showEmpty();
            }
        });

        bt_showErrorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading_layout.showError();
            }
        });

        bt_showContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading_layout.showContent();
            }
        });
    }
}
