package com.yanzhikai.testappexit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;

import org.reactivestreams.Subscription;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by yany on 2017/5/21.
 */

public class BaseApplication extends Application {
    private static final String TAG = "TestAppExit";
    private static LinkedList<Activity> activityLinkedList;
    public static final String EXIT = "action.exit";


    @Override
    public void onCreate() {
        super.onCreate();

        activityLinkedList = new LinkedList<>();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d(TAG, "onActivityCreated: " + activity.getLocalClassName());
                Log.d(TAG, "Pid: " +  + Process.myPid());
//                Log.d(TAG, "Uid: " +  + Process.myUid());
                activityLinkedList.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.d(TAG, "onActivityStarted: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.d(TAG, "onActivityStopped: " + activity.getLocalClassName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.d(TAG, "onActivityDestroyed: " + activity.getLocalClassName());
                activityLinkedList.remove(activity);
            }
        });
    }


    public static void showList() {
        for (Activity activity : activityLinkedList) {
            Log.d(TAG, "showList: " + activity.getLocalClassName());
        }
    }

    public static void exitAppList() {
        for (Activity activity : activityLinkedList) {
            activity.finish();
        }
    }

    public static String getTAG() {
        return TAG;
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public static void getStack(Context context){
//        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
//        List<ActivityManager.RunningTaskInfo> runTaskList = am.getRunningTasks(10);
//        for (ActivityManager.RunningTaskInfo runningTaskInfo : runTaskList){
//            Log.d(TAG, "getStackBaseActivity: " + runningTaskInfo.baseActivity);
//            Log.d(TAG, "getStackTopActivity: " + runningTaskInfo.topActivity);
//        }
//        List<ActivityManager.AppTask> appTaskList = am.getAppTasks();
//        for (ActivityManager.AppTask appTask : appTaskList){
//            Log.d(TAG, "description: " + appTask.getTaskInfo().description);
//            Log.d(TAG, "baseIntent: " + appTask.getTaskInfo().baseIntent);
//        }
//
//        Log.d(TAG, "------------------------------------");
//        Log.d(TAG, "appTaskSize: " + appTaskList.size());
//    }


}
