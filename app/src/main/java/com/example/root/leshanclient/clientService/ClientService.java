package com.example.root.leshanclient.clientService;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import android.support.annotation.Nullable;

import com.example.root.leshanclient.demo.LeshanClientDemo;

import org.eclipse.leshan.client.californium.LeshanClient;
import org.eclipse.leshan.client.californium.LeshanClientBuilder;

import java.util.ArrayList;
//import com.advantech.lib.Advanlib;


/**
 * Created by root on 10/12/18.
 */

public class ClientService extends Service {
    private static Context mContext;
    public static Intent start(Context context) {
        //MQTTRmmService mMQTTService = new MQTTRmmService();
        //Intent mServiceIntent = new Intent(context.getApplicationContext(), mMQTTService.getClass());
        Intent mServiceIntent = new Intent(context.getApplicationContext(), ClientService.class);

        // Start the service
        context.startService(mServiceIntent);
        mContext = context;
        return mServiceIntent;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("testservice","run");
//        String endpoint = "...";
//        LeshanClientBuilder builder = new LeshanClientBuilder(endpoint);
//        LeshanClient client = builder.build();
//        client.start();
//        return super.onStartCommand(intent, flags, startId);
        LeshanClientDemo leshanClientDemo = new LeshanClientDemo();
        String[] argus = new String[1];
        leshanClientDemo.start(argus);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }




}
