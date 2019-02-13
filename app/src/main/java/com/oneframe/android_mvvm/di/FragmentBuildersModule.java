package com.oneframe.android_mvvm.di;


import com.oneframe.android_mvvm.view.project.ui.ProjectFragment;
import com.oneframe.android_mvvm.view.project.ui.ProjectListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract ProjectFragment contributeProjectFragment();

    @ContributesAndroidInjector
    abstract ProjectListFragment contributeProjectListFragment();
}
