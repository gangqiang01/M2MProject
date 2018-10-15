package com.example.root.leshanclient.clientService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by root on 10/12/18.
 */

public class ClientServiceBroadcastReceive extends BroadcastReceiver {
    public ClientServiceBroadcastReceive() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("clientservice", "debug 1");
        context.startService(new Intent(context, ClientService.class));

    }
}
