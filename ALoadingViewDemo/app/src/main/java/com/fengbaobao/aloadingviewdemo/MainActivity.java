package com.fengbaobao.aloadingviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by FengBaobao on 3/1/16.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_main);

        Button bt_originalEffect = (Button) findViewById(R.id.bt_originalEffect);
    }
}
