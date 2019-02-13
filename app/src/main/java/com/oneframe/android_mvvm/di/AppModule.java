package com.oneframe.android_mvvm.di;

import android.arch.lifecycle.ViewModelProvider;
import com.oneframe.android_mvvm.service.GitHubNetworkManager;
import com.oneframe.android_mvvm.viewmodel.project.ProjectViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {

    /*
    @Singleton @Provides
    GitHubService provideGithubService() {
        return new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubService.class);
    }
    */

    @Provides
    GitHubNetworkManager provideNetworkManager() {
        return new GitHubNetworkManager();
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ProjectViewModelFactory(viewModelSubComponent.build());
    }
}
