package com.oneframe.android_mvvm.repository;

/**
 * Created by ub on 11/02/2018.
 */
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;


import com.oneframe.android.networking.listener.NetworkResponseListener;
import com.oneframe.android.networking.model.ErrorModel;
import com.oneframe.android.networking.model.ResultModel;
import com.oneframe.android.sqlite.BaseRepository;
import com.oneframe.android_mvvm.db.ProjectDao;
import com.oneframe.android_mvvm.model.Project;
import com.oneframe.android_mvvm.service.GitHubNetworkManager;

import java.util.List;

import javax.inject.Inject;


public class ProjectRepository extends BaseRepository<Project, ProjectDao> {
    //private GitHubService gitHubService;
    private GitHubNetworkManager networkManager;
    //private static ProjectRepository projectRepository;

    @Inject
    public ProjectRepository(GitHubNetworkManager networkManager)
    {
        this.networkManager = networkManager;
    }
    public LiveData<List<Project>> getProjectList(String userId) {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        networkManager.getProjectList(userId, new NetworkResponseListener<List<Project>, String>() {
            @Override
            public void onSuccess(ResultModel<List<Project>> resultModel) {
                data.setValue(resultModel.getModel());
                insertAll(resultModel.getModel());
            }
            @Override
            public void onError(ErrorModel<String> errorModel) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<Project> getProjectDetails(String userID, String projectName) {
        final MutableLiveData<Project> data = new MutableLiveData<>();
        networkManager.getProjectDetails(userID,projectName, new NetworkResponseListener<Project, String>() {
            @Override
            public void onSuccess(ResultModel<Project> resultModel) {
                simulateDelay();
                data.setValue(resultModel.getModel());
            }
            @Override
            public void onError(ErrorModel<String> errorModel) {
                data.setValue(null);
            }
        });
        return data;
    }


    private void simulateDelay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}