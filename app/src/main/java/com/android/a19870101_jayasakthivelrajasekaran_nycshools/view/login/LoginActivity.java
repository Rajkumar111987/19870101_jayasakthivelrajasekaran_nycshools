package com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.a19870101_jayasakthivelrajasekaran_nycshools.databinding.ActivityLoginBinding;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.BaseActivity;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.splash.MainActivity;

public class LoginActivity extends BaseActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        ActivityLoginBinding mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.siginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAndClearStack(MainActivity.class);
            }
        });

    }
}
