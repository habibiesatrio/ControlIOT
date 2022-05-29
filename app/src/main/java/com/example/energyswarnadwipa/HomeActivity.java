package com.example.energyswarnadwipa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void monitor(View view) {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void panduan(View view) {
        Intent intent = new Intent(HomeActivity.this, PanduanActivity.class);
        startActivity(intent);
    }

    public void history(View view){
        Intent intent = new Intent(HomeActivity.this, HistoryActivity.class);
        startActivity(intent);
    }

    public void Image_button(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}

//public class HomeActivity extends AppCompatActivity {
//deklarasi tombol
//ImageView panduan, monitor;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        panduan = (ImageView) findViewById(R.id.panduan_app);
//        panduan.setOnClickListener(View.OnClickListener() {
//            @Override
//            public void onClick (View v){
//                Intent i = null;
//                i = Intent(getApplicationContext(), PanduanActivity.class);
//                startActivity(i);
//            }
//        })
//
//        monitor = (ImageView) findViewById(R.id.monitor_set);
//        monitor.setOnClickListener(View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent i = null;
//                i = Intent(getApplicationContext(), MainActivity.class);
//                startActivity(i);
//            }
//        });