package com.example.root.leshanclient.clientService;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import android.support.annotation.Nullable;

import com.ibm.lwm2m.client.LwM2MClient;
import com.ibm.lwm2m.client.LwM2MExampleClient;
import com.ibm.lwm2m.objects.LwM2MExampleDeviceObject;


/**
 * Created by root on 10/12/18.
 */

public class ClientService extends Service {
    private static Context mContext;
    private LwM2MClient client;

    public static Intent start(Context context) {
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
        registClient();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        client.deregister();
        super.onDestroy();
    }
    private  void registClient() {
        client = LwM2MClient.getClient(mContext);
        client.start();
        // Create the device object
        LwM2MExampleDeviceObject.createObject(mContext);
        LwM2MExampleDeviceObject.createObjectInstance(mContext);
        client.register();
    }

}
