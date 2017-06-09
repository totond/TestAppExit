package com.yanzhikai.testappexit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by yany on 2017/6/1.
 */

public class CloseReceiver extends BroadcastReceiver {
    private Activity activity;

    public CloseReceiver(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        activity.finish();
    }
}
