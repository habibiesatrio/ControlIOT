package com.example.energyswarnadwipa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AbsListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView listlog;
    LogAdapter logAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Report");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listlog = findViewById(R.id.list_view);

        list<Log> logs = ArrayList<>();
        listlog.setLayoutManager(LinearLayoutManager(getApplicationContext()));
        logAdapter = logAdapter(logs);
        listlog.setAdapter(logAdapter);

        reference.orderByChild("tanggal").addChildEventListener(ChildEventListener(){
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot,@Nullable String previousChildName){
                logs.add(snapshot.getValue(Log.class));
                Collections.sort(logs);
                logAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull  DataSnapshot snapshot, @Nullable  String previousChildName) {
                for (int i = 0; i < logs.size(); i++) {
                    Log log = logs.get(i);
                    if(String.valueOf(log.getTanggal()).equals(snapshot.getKey())) {
                        logs.set(i, snapshot.getValue(Log.class));
                    }
                }
                Collections.sort(logs);
                logAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull  DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull  DataSnapshot snapshot, @Nullable  String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }

    public void kembali(View view) {
        finish();
    }