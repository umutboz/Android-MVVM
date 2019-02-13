package com.oneframe.android_mvvm.db;

import android.arch.persistence.room.Database;

import com.oneframe.android.sqlite.BaseDatabase;
import com.oneframe.android_mvvm.model.Project;
import com.oneframe.android_mvvm.model.User;


/**
 * Created by ub on 11/02/2018.
 */

@Database(entities = {Project.class, User.class} , version = 1)
public abstract class GitHubDatabase extends BaseDatabase<GitHubDatabase> {

    public abstract UserDao userModel();
    public abstract ProjectDao projectModel();

}
