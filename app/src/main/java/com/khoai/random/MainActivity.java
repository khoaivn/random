package com.khoai.random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Random rand = new Random();
        final EditText et_from = (EditText)findViewById(R.id.from);
        final EditText et_to = (EditText)findViewById(R.id.to);
        Button bt = (Button)findViewById(R.id.bt_result);
        final TextView tv = (TextView)findViewById(R.id.tv_result);
        bt.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tv.setText("");
                String from = et_from.getText().toString();
                String to = et_to.getText().toString();
                int min = Integer.parseInt(from);
                int max = Integer.parseInt(to);
                if (min > max)
                    Toast.makeText( MainActivity.this, "error!", Toast.LENGTH_LONG).show();
                else {
                    int u = rand.nextInt((max - min) + 1) + min;
                    tv.setText(String.valueOf(u));
                }
            }
        });

        MobileAds.initialize(getApplicationContext(), getString(R.string.banner_ad_unit_id));

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
}
