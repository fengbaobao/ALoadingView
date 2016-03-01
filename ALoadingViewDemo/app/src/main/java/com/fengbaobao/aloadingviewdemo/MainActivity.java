package com.fengbaobao.aloadingviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        Button bt_customMade = (Button) findViewById(R.id.bt_customMade);
        Button bt_xmlSpecialMade = (Button) findViewById(R.id.bt_xmlSpecialMade);

        bt_originalEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, OriginalEffectActivity.class);
                startActivity(mIntent);
            }
        });

        bt_customMade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, CustomMadeActivity.class);
                startActivity(mIntent);
            }
        });

        bt_xmlSpecialMade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, XMLSpecialMadeActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
