package com.yanzhikai.testappexit;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by yany on 2017/6/8.
 */

public class TestButton extends Button implements View.OnClickListener{
    private Context context;
    public TestButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public TestButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(BaseApplication.getTAG(), "按下Test———————————————————————————— ");
        System.exit(0);
//        Runtime.getRuntime().exit(0);

//        Process.killProcess(Process.myPid());

//        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//        activityManager.killBackgroundProcesses(context.getPackageName());
//
//        activityManager.restartPackage(context.getPackageName());
    }
}
