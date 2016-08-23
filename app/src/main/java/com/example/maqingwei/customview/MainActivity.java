package com.example.maqingwei.customview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Commonbar bar = (Commonbar) findViewById(R.id.mycomonbar);

        bar.setTopOnclickListener(new Commonbar.ClickListener() {
            @Override
            public void onleftclick() {
                Toast.makeText(MainActivity.this,"点击了左按钮",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onrightclick() {
                Toast.makeText(MainActivity.this,"点击了右按钮",Toast.LENGTH_LONG).show();
            }
        });
    }
}
