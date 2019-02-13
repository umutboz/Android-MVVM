package com.oneframe.android_mvvm.model;

/**
 * Created by ub on 11/02/2018.
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;


import com.oneframe.android.sqlite.BaseModel;
import com.oneframe.android.sqlite.utils.DateConverter;

import java.util.Date;

@TypeConverters(DateConverter.class)
@Entity
public class User extends BaseModel<Long> {
    public String login;
    //public long id;


    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public String name;
    public String blog;
    public String location;
    public String email;
    public int public_repos;
    public int public_gists;
    public int followers;
    public int following;
    public Date created_at;
    public Date updated_at;
}
