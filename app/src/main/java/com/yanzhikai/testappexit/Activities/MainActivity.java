package com.yanzhikai.testappexit.Activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yanzhikai.testappexit.Activities.A0Activity;
import com.yanzhikai.testappexit.CloseButton;
import com.yanzhikai.testappexit.CloseReceiver;
import com.yanzhikai.testappexit.JumpActivityButton;
import com.yanzhikai.testappexit.R;
import com.yanzhikai.testappexit.RxBus;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.yanzhikai.testappexit.BaseApplication.EXIT;

public class MainActivity extends AppCompatActivity {
    private JumpActivityButton btn_jumpA0;
    private CloseButton btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_jumpA0 = (JumpActivityButton) findViewById(R.id.btn_jumpA0);
        Intent intent = new Intent(this,A0Activity.class);
        btn_jumpA0.setIntent(intent);
        btn_close = (CloseButton) findViewById(R.id.btn_close);

        //exitApp4()方法使用
        initRxBusExit();

        //exitApp5()方法使用
        closeReceiver = new CloseReceiver(this);
        registerReceiver(closeReceiver,new IntentFilter(EXIT));
    }

    //exitApp4()方法使用
    private Disposable disposable;

    //exitApp5()方法使用
    private CloseReceiver closeReceiver;

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

    //exitApp3()方法使用
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            boolean isExitApp = intent.getBooleanExtra("exit", false);
            if (isExitApp) {
                this.finish();
            }
        }
    }


}
