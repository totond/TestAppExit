package com.yanzhikai.testappexit;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.yanzhikai.testappexit.Activities.MainActivity;

import java.util.List;

/**
 * Created by yany on 2017/5/22.
 */

public class CloseButton extends android.support.v7.widget.AppCompatButton implements View.OnClickListener {
    private Context context;

    public CloseButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CloseButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CloseButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.d(BaseApplication.getTAG(), "按下Close———————————————————————————— ");
//        exitAPP1();
//        exitAPP2();
//        exitAPP3();
        exitAPP4();
//        exitAPP5();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void exitAPP1() {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
        Log.d(BaseApplication.getTAG(), "exitAPP1:size :  " + appTaskList.size());
        for (ActivityManager.AppTask appTask : appTaskList) {
            appTask.finishAndRemoveTask();
        }
//        appTaskList.get(0).finishAndRemoveTask();
        System.exit(0);
    }

    private void exitAPP2() {
        BaseApplication.showList();
        BaseApplication.exitAppList();
        System.exit(0);
    }

    private void exitAPP3() {
        Intent intent = new Intent(context, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("exit", true);
        context.startActivity(intent);
        System.exit(0);
    }

    private void exitAPP4() {
        RxBus.getInstance().post("exit");
        System.exit(0);
    }

    private void exitAPP5() {
        context.sendBroadcast(new Intent(BaseApplication.EXIT));
//        System.exit(0);
    }
}
