package com.example.worldclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private TextView tvSydney;
    private TextView tvBeijing;
    private TextView tvNewYork;
    private TextView tvBerlin;
    private TextView tvLondon;
    private TextView tvMoscow;
    private TextView tv12;
    private TextView tv24;
    private String flag="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        handler.postDelayed(runnable, 1000);
    }

    private void initEvent() {
        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag="0";
                tv12.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tv12.setTextColor(getResources().getColor(R.color.white));
                tv24.setBackgroundColor(getResources().getColor(R.color.white));
                tv24.setTextColor(getResources().getColor(R.color.colorPrimary));
                getWorldTime();
            }
        });

        tv24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag="1";
                tv24.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tv24.setTextColor(getResources().getColor(R.color.white));
                tv12.setBackgroundColor(getResources().getColor(R.color.white));
                tv12.setTextColor(getResources().getColor(R.color.colorPrimary));
                getWorldTime();
            }
        });
    }


    Handler handler=new Handler();

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            getWorldTime();
            handler.postDelayed(this, 1000);
        }
    };

    private void getWorldTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = null;
        if (flag.equals("0")){
            sdf = new SimpleDateFormat("hh:mm");

        }else {
            sdf = new SimpleDateFormat("HH:mm");
        }
        sdf.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        tvSydney.setText(sdf.format(calendar.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        tvBeijing.setText(sdf.format(calendar.getTime()));


        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        tvNewYork.setText(sdf.format(calendar.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        tvBerlin.setText(sdf.format(calendar.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        tvLondon.setText(sdf.format(calendar.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        tvMoscow.setText(sdf.format(calendar.getTime()));


    }

    private void initView() {
        tvSydney=findViewById(R.id.tv_sydney);
        tvBeijing=findViewById(R.id.tv_beijing);
        tvNewYork=findViewById(R.id.tv_new_york);
        tvBerlin=findViewById(R.id.tv_berlin);
        tvLondon=findViewById(R.id.tv_london);
        tvMoscow=findViewById(R.id.tv_moscow);
        tv12=findViewById(R.id.tv_12);
        tv24=findViewById(R.id.tv_24);
    }
}
