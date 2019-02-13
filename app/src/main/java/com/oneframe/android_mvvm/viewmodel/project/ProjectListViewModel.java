package com.oneframe.android_mvvm.viewmodel.project;


/**
 * Created by ub on 11/02/2018.
 */


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.oneframe.android_mvvm.model.Project;
import com.oneframe.android_mvvm.repository.ProjectRepository;


import java.util.List;

import javax.inject.Inject;

public class ProjectListViewModel extends AndroidViewModel {

    private final LiveData<List<Project>> projectListObservable;



    //yerine dagger
    /*
    public ProjectListViewModel(Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = ProjectRepository.getInstance().getProjectList("Google");


    }
    */

    @Inject
    public ProjectListViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);
        projectListObservable = projectRepository.getProjectList("Google");
    }


    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
