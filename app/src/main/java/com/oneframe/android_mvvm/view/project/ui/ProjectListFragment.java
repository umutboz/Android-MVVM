package com.oneframe.android_mvvm.view.project.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.oneframe.android_mvvm.R;
import com.oneframe.android_mvvm.databinding.FragmentProjectListBinding;
import com.oneframe.android_mvvm.di.Injectable;
import com.oneframe.android_mvvm.model.Project;
import com.oneframe.android_mvvm.view.project.adapter.ProjectAdapter;
import com.oneframe.android_mvvm.view.project.callback.ProjectClickCallback;
import com.oneframe.android_mvvm.viewmodel.project.ProjectListViewModel;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by ub on 11/02/2018.
 */

public class ProjectListFragment extends Fragment implements Injectable {
    public static final String TAG = "ProjectListFragment";
    private ProjectAdapter projectAdapter;
    private FragmentProjectListBinding binding;

    //dagger için
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);

        projectAdapter = new ProjectAdapter(projectClickCallback);
        binding.projectList.setAdapter(projectAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //final ProjectListViewModel viewModel = ViewModelProviders.of(this).get(ProjectListViewModel.class);
        //yerine dagger
        final ProjectListViewModel viewModel = ViewModelProviders.of(this,
                viewModelFactory).get(ProjectListViewModel.class);
        observeViewModel(viewModel);
    }

    private void observeViewModel(ProjectListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if (projects != null) {
                    binding.setIsLoading(false);
                    projectAdapter.setProjectList(projects);
                }
            }
        });
    }

    private final ProjectClickCallback projectClickCallback = new ProjectClickCallback() {
        @Override
        public void onClick(Project project) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((MainActivity) getActivity()).show(project);
            }
        }
    };
}
