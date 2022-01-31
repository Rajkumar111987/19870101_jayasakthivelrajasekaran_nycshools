package com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.splash;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.a19870101_jayasakthivelrajasekaran_nycshools.R;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.databinding.ActivityMainBinding;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.model.HighSchoolsJson;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.BaseActivity;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.dashboard.activity.DashboardActivity;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.viewModel.SchoolViewModel;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mBinding;
    public int timerforprogressbar = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        intializeView();
    }

    private void intializeView() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                openAndClearStack(DashboardActivity.class);
            }

        }, timerforprogressbar);
    }
}