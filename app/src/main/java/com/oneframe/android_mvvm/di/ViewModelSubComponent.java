package com.oneframe.android_mvvm.di;



import com.oneframe.android_mvvm.viewmodel.project.ProjectListViewModel;
import com.oneframe.android_mvvm.viewmodel.project.ProjectViewModel;

import dagger.Subcomponent;

/**
 * A sub component to create ViewModels. It is called by the
 * {@link com.oneframe.android_mvvm.viewmodel.project.ProjectViewModelFactory}.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ProjectListViewModel projectListViewModel();
    ProjectViewModel projectViewModel();
}
