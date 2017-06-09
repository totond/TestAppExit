package com.yanzhikai.testappexit;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by yany on 2017/5/21.
 */

public class JumpActivityButton extends Button implements View.OnClickListener{
    private Intent intent;
    private Context context;

    public JumpActivityButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public JumpActivityButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public JumpActivityButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init(){
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (intent == null){
            Log.e(BaseApplication.getTAG(),"intent is null");
        }else {
            context.startActivity(intent);
        }
    }

    //设置Intent
    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
