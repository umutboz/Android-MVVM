package com.oneframe.android_mvvm.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.oneframe.android.sqlite.IBaseDao;
import com.oneframe.android_mvvm.model.User;

import java.util.List;


/**
 * Created by ub on 11/02/2018.
 */

@Dao
public abstract class UserDao implements IBaseDao<User> {


    @Query("select * from user where id = :id")
    public abstract User loadUserById(int id);

    /*
    @Query("select * from user where name = :firstName and lastName = :lastName")
    public abstract List<User> findUserByNameAndLastName(String firstName, String lastName);

    @Query("delete from user where name like :badName OR lastName like :badName")
    public abstract int deleteUsersByName(String badName);
    */


    /*
    @Query("SELECT * FROM User WHERE age < :age") // TODO: Fix this!
    public abstract List<User> findUsersYoungerThan(int age);
    */

    /*
    @Query("SELECT * FROM User WHERE age < :age")
    public abstract List<User> findUsersYoungerThanSolution(int age);
    */

}
