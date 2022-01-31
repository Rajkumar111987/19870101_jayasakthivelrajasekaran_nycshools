package com.android.a19870101_jayasakthivelrajasekaran_nycshools.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.a19870101_jayasakthivelrajasekaran_nycshools.utils.FragmentScreenNavigation;

public class FragmentTransitionViewModel extends AndroidViewModel {
    MutableLiveData<FragmentScreenNavigation> mData = new MutableLiveData();
    public FragmentTransitionViewModel(@NonNull Application application) {
        super(application);
    }

    public void setScreenNav(FragmentScreenNavigation data ){ mData.postValue(data);}

    public LiveData<FragmentScreenNavigation> getScreenNav() { return mData;}
}
