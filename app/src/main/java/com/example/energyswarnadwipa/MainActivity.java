package com.example.energyswarnadwipa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //inisiasi nilai tampilan
    private TextView nCurrent;
    private TextView nPower;
    private TextView nVolt;
    private Button btnPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //baca komponen sensor
        nCurrent = (TextView) findViewById(R.id.nCurrent1);
        nPower = (TextView) findViewById(R.id.nPower1);
        nVolt = (TextView) findViewById(R.id.nVolt1);
        btnPower = (Button) findViewById(R.id.btnPower1);

        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void btnPower (View view) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
                    }
                }
            }
        });
        //koneksi firebase
        Firebase mCur = new Firebase("https://tugas-akhir-5fe83-default-rtdb.firebaseio.com/Current/float");
        Firebase mPow = new Firebase("https://tugas-akhir-5fe83-default-rtdb.firebaseio.com/Power/float");
        Firebase mVol = new Firebase("https://tugas-akhir-5fe83-default-rtdb.firebaseio.com/Volt");

        //proses realtime
        mCur.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //ambil nilai field value
                String nCurrent1 = dataSnapshot.getValue(String.class);
                //tampilkan ke komponen nilai
                nCurrent.setText(nCurrent1);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        mPow.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nPower1 = dataSnapshot.getValue(String.class);
                nPower.setText(nPower1);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        mVol.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nVolt1 = dataSnapshot.getValue(String.class);
                nVolt.setText(nVolt1);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}
//public class MainActivity extends AppCompatActivity {
//
//    //inisialisasi textview nilai
//    private TextView pointk ;
//    private TextView pointk1 ;
//    private TextView pointacs ;
//    private TextView nilaizmpt ;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //baca komponen nilai(textview)
//        pointk = (TextView)findViewById(R.id.pointk) ;
//        pointk1 = (TextView)findViewById(R.id.pointk1);
//        pointacs = (TextView)findViewById(R.id.pointacs);
//        nilaizmpt = findViewById(R.id.nilaizmpt);
//
//        //buka koneksi ke firebase
//        Firebase mRef = new Firebase("https://energiswarnadwipa.firebaseio.com/energiswarnadwipa/nilaik");
//        Firebase mPap = new Firebase("https://energiswarnadwipa.firebaseio.com/energiswarnadwipa/nilaisms");
//        Firebase mBap = new Firebase( "https://energiswarnadwipa.firebaseio.com/energiswarnadwipa/nilaiacs");
//        Firebase mCap = new Firebase( "https://energiswarnadwipa.firebaseio.com/energiswarnadwipa/nilaizmpt");
//
//        //proses realtime
//        mRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //ambil nilai field value
//                String nilaik = dataSnapshot.getValue(String.class);
//                //tampilkan ke komponen nilai
//                pointk.setText(nilaik);
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//
//        });
//
//        mPap.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String nilaisms = dataSnapshot.getValue(String.class);
//                pointk1.setText(nilaisms);
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//
//        mBap.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String nilaiacs =
//                        dataSnapshot.getValue(String.class);
//                pointacs.setText(nilaiacs);
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//
//        mCap.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String nilaitegangan = dataSnapshot.getValue(String.class);
//                nilaizmpt.setText(nilaitegangan);
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//    }
//}