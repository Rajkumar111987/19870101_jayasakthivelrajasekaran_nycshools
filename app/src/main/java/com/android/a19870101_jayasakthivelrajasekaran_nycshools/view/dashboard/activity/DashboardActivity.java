package com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.dashboard.activity;

import android.os.Bundle;
import android.util.Log;

import com.android.a19870101_jayasakthivelrajasekaran_nycshools.R;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.databinding.ActivityBaseBinding;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.model.HighSchoolsJson;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.utils.FragmentScreenNavigation;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.BaseActivity;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.dashboard.fragment.DashboardDetailCustomFragment;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.view.dashboard.fragment.DashboardListFragment;

import java.util.List;


public class DashboardActivity extends BaseActivity {
    private static final String TAG = DashboardActivity.class.getSimpleName();

    private ActivityBaseBinding mBinding;

    public List<HighSchoolsJson> mSchools;
    public String  SCHOOL_ID = "school_id";
    public int school_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBaseBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        Log.d(TAG,"onCreate");
        intializeFragmentTrans();
        setScreenData(0,FragmentScreenNavigation.DASHBOARD_LIST);
    }

    public void setScreenData(int id ,FragmentScreenNavigation nav ){
        school_id = id;
        mFragViewModel.setScreenNav(nav);
    }

    @Override
    public void onShowNextFragment(FragmentScreenNavigation screenNavigation) {
        super.onShowNextFragment(screenNavigation);

        String tag ="";

        switch (screenNavigation){
            case DASHBOARD_LIST:{
                navFragment = new DashboardListFragment();
                tag = DashboardListFragment.TAG;
                break;
            }
            case DASHBOARD_DETAIL_CUSTOM:{
                navFragment = new DashboardDetailCustomFragment();
                tag = DashboardDetailCustomFragment.TAG;
                break;
            }
        }
        Bundle args = new Bundle();
        args.putInt(SCHOOL_ID,school_id);
        showFragment(navFragment, args, R.id.frameLayout, true, R.anim.fade_in,
                R.anim.slide_from_center_to_left, R.anim.slide_from_left_to_center,
                R.anim.slide_from_center_to_right, tag);
    }

    @Override
    public void onPositiveClick() {
        if(navFragment instanceof DashboardListFragment){
            ((DashboardListFragment) navFragment).onPositiveClick();
        }else if (navFragment instanceof DashboardDetailCustomFragment){
            ((DashboardDetailCustomFragment) navFragment).onPositiveClick();
        }
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 1) {
            getSupportFragmentManager().popBackStack();
        }else{
            showAlertDialog();
        }
    }

    private void showAlertDialog() {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(getText(R.string.error_dialog_exit_message));
            builder.setPositiveButton(getText(R.string.error_dialog_ok), (dialog, which) -> {
                finish();
                dialog.dismiss();
            }).setNegativeButton(getText(R.string.error_dialog_cancel), (dialog, which) -> dialog.dismiss()).show();
    }

    @Override
    public void onNegativeClick() {
        if(navFragment instanceof DashboardListFragment){
            showAlertDialog();
        } else if (navFragment instanceof DashboardDetailCustomFragment){
            onBackPressed();
        }
    }
}
