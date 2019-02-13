package com.oneframe.android_mvvm.view.project.adapter;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by ub on 11/02/2018.
 */


public class CustomBindingAdapter {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
