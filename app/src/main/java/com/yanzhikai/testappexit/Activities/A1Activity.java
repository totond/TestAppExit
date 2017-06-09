package com.yanzhikai.testappexit.Activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yanzhikai.testappexit.CloseReceiver;
import com.yanzhikai.testappexit.JumpActivityButton;
import com.yanzhikai.testappexit.R;
import com.yanzhikai.testappexit.RxBus;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.yanzhikai.testappexit.BaseApplication.EXIT;

public class A1Activity extends AppCompatActivity {
    private JumpActivityButton btn_jumpB0,btn_jumpC0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
        btn_jumpB0 = (JumpActivityButton) findViewById(R.id.btn_jumpB0);
        Intent intent = new Intent(this,B0Activity.class);
        btn_jumpB0.setIntent(intent);
        btn_jumpC0 = (JumpActivityButton) findViewById(R.id.btn_jumpC0);
        Intent intent1 = new Intent(this,C0Activity.class);
        btn_jumpC0.setIntent(intent1);

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
}
