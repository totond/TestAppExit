package com.yanzhikai.testappexit.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.yanzhikai.testappexit.JumpActivityButton;
import com.yanzhikai.testappexit.R;

public class C0Activity extends BasedActivity {
    private JumpActivityButton btn_jumpC1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0);
        btn_jumpC1 = (JumpActivityButton) findViewById(R.id.btn_jumpC1);
        Intent intent = new Intent(this,C1Activity.class);
        btn_jumpC1.setIntent(intent);
        //exitApp4()方法使用
//        initRxBusExit();
//
//        //exitApp5()方法使用
//        closeReceiver = new CloseReceiver(this);
//        registerReceiver(closeReceiver,new IntentFilter(EXIT));
    }

//    //exitApp4()方法使用
//    private Disposable disposable;
//
//    //exitApp5()方法使用
//    private CloseReceiver closeReceiver;
//
//    //exitApp4()方法使用注册订阅
//    private void initRxBusExit(){
//        disposable = RxBus.getInstance().toObservable(String.class)
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        if (s.equals("exit")){
//                            finish();
//                        }
//                    }
//                });
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //exitApp4()方法使用取消订阅
//        if (!disposable.isDisposed()){
//            disposable.dispose();;
//        }
//        //exitApp5()方法使用
//        unregisterReceiver(closeReceiver);
//    }
}
