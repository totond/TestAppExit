package com.yanzhikai.testappexit.Activities;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yanzhikai.testappexit.CloseReceiver;
import com.yanzhikai.testappexit.RxBus;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.yanzhikai.testappexit.BaseApplication.EXIT;

/**
 * Created by yany on 2017/6/9.
 */

public class BasedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //exitApp4()方法使用
        initRxBusExit();

        //exitApp5()方法使用
        closeReceiver = new CloseReceiver(this);
        registerReceiver(closeReceiver,new IntentFilter(EXIT));
    }



    //exitApp4()方法使用
    private Disposable disposable;

    //exitApp4()方法使用注册订阅
    private void initRxBusExit(){
        disposable = RxBus.getInstance().toObservable(String.class)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if (s.equals("exit")){
                            finish();
                        }
                    }
                });
    }

    //exitApp5()方法使用
    private CloseReceiver closeReceiver;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //exitApp4()方法使用取消订阅
        if (!disposable.isDisposed()){
            disposable.dispose();;
        }
        //exitApp5()方法使用
        unregisterReceiver(closeReceiver);
    }
}
