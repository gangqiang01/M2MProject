package com.example.root.leshanclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.root.leshanclient.clientService.ClientService;

public class MainActivity extends AppCompatActivity {
    private Intent mServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mServiceIntent = ClientService.start( this.getApplicationContext() );
//        Log.e(TAG, "--------->onCreate: ");
    }

    @Override
    protected void onDestroy() {
        if(mServiceIntent!=null) {
            stopService(mServiceIntent);
        }
        super.onDestroy();

    }
}
