package com.oneframe.android_mvvm.service;

import android.content.Context;


import com.oneframe.android.networking.NetworkConfig;
import com.oneframe.android.networking.NetworkManager;
import com.oneframe.android.networking.NetworkingFactory;
import com.oneframe.android.networking.listener.NetworkResponseListener;
import com.oneframe.android_mvvm.model.Project;


import java.util.List;


/**
 * Created by umutboz on 19.6.2017 .
 */

public class GitHubNetworkManager {

    NetworkManager networkManager;

    public GitHubNetworkManager() {

        networkManager = NetworkingFactory.create();
        NetworkConfig.getInstance().setURL("https://api.github.com/");
    }


    public void getProjectList(String userId ,final NetworkResponseListener<List<Project>, String> listener) {
        networkManager.get(String.format("users/%s/repos",userId), listener);
    }
    public void getProjectDetails(String userId ,String projectId, final NetworkResponseListener<Project, String> listener) {
        networkManager.get(String.format("repos/%s/%s",userId,projectId), listener);
    }

}
