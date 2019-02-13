package com.oneframe.android_mvvm.repository;


import com.oneframe.android.sqlite.BaseRepository;
import com.oneframe.android_mvvm.db.UserDao;
import com.oneframe.android_mvvm.model.User;

/**
 * Created by ub on 11/02/2018.
 */

public class UserRepository extends BaseRepository<User, UserDao> {


    public UserRepository() {


    }
}
