package com.oneframe.android_mvvm.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.oneframe.android.sqlite.IBaseDao;
import com.oneframe.android_mvvm.model.Project;



import java.util.List;

/**
 * Created by umutboz on 05,January,2018
 */

@Dao
public abstract  class ProjectDao implements IBaseDao<Project> {


    @Query("SELECT * FROM Project where id = :id")
    public abstract List<Project> getById(int id);

}