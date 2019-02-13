package com.oneframe.android_mvvm;

import android.app.Activity;
import android.app.Application;


import com.oneframe.android.networking.NetworkingFactory;
import com.oneframe.android_mvvm.di.AppInjector;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MVVMApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkingFactory.init(this);
        AppInjector.init(this);

    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
