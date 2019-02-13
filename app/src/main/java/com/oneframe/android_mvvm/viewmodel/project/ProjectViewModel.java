package com.oneframe.android_mvvm.viewmodel.project;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.oneframe.android_mvvm.model.Project;
import com.oneframe.android_mvvm.repository.ProjectRepository;


import javax.inject.Inject;


/**
 * Created by ub on 11/02/2018.
 */

public class ProjectViewModel extends AndroidViewModel {
    private static final String TAG = ProjectViewModel.class.getName();
    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }
    private final LiveData<Project> projectObservable;
    private final MutableLiveData<String> projectID;

    public ObservableField<Project> project = new ObservableField<>();


    public void setProject(Project project) {
        this.project.set(project);
    }
    public void setProjectID(String projectID) {
        this.projectID.setValue(projectID);
    }
    public LiveData<Project> getObservableProject() {
        return projectObservable;
    }


    //dagger ile
    @Inject
    public ProjectViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);

        this.projectID = new MutableLiveData<>();
        projectObservable = Transformations.switchMap(projectID, input -> {
            if (input.isEmpty()) {
                Log.i(TAG, "ProjectViewModel projectID is absent!!!");
                return ABSENT;
            }
            Log.i(TAG,"ProjectViewModel projectID is " + projectID.getValue());
            return projectRepository.getProjectDetails("Google", projectID.getValue());
        });
    }


    /*
    public ProjectViewModel(@NonNull Application application,
                            final String projectID) {
        super(application);
        this.projectID = projectID;

        projectObservable = ProjectRepository.getInstance(application).getProjectDetails("Google", projectID);
    }

*/




    /**
     * A creator is used to inject the project ID into the ViewModel
     */
    /*
    Dagger ileihtiyhaç kalmadı
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        private final String projectID;

        public Factory(@NonNull Application application, String projectID) {
            this.application = application;
            this.projectID = projectID;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new ProjectViewModel(application, projectID);
        }
    }

    */

}
