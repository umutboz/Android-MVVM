package com.oneframe.android_mvvm.view.project.ui;


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
import com.oneframe.android_mvvm.databinding.FragmentProjectDetailsBinding;
import com.oneframe.android_mvvm.di.Injectable;
import com.oneframe.android_mvvm.model.Project;
import com.oneframe.android_mvvm.viewmodel.project.ProjectViewModel;

import javax.inject.Inject;

/**
 * Created by ub on 11/02/2018.
 */

public class ProjectFragment extends Fragment implements Injectable {
    private static final String KEY_PROJECT_ID = "project_id";
    private FragmentProjectDetailsBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_details, container, false);

        // Create and set the adapter for the RecyclerView.
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //ProjectViewModel.Factory factory = new ProjectViewModel.Factory(getActivity().getApplication(), getArguments().getString(KEY_PROJECT_ID));
        //final ProjectViewModel viewModel = ViewModelProviders.of(this, factory).get(ProjectViewModel.class);
        //DAGGER ile
        final ProjectViewModel viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(ProjectViewModel.class);

        viewModel.setProjectID(getArguments().getString(KEY_PROJECT_ID));
        binding.setProjectViewModel(viewModel);
        binding.setIsLoading(true);

        observeViewModel(viewModel);
    }

    private void observeViewModel(final ProjectViewModel viewModel) {
        // Observe project data
        viewModel.getObservableProject().observe(this, new Observer<Project>() {
            @Override
            public void onChanged(@Nullable Project project) {
                if (project != null) {
                    binding.setIsLoading(false);
                    viewModel.setProject(project);
                }
            }
        });
    }

    /** Creates project fragment for specific project ID */
    public static ProjectFragment forProject(String projectID) {
        ProjectFragment fragment = new ProjectFragment();
        Bundle args = new Bundle();

        args.putString(KEY_PROJECT_ID, projectID);
        fragment.setArguments(args);

        return fragment;
    }
}
