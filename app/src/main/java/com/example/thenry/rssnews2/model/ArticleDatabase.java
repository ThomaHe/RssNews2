package com.example.thenry.rssnews2.model;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by thenry on 22/02/2017.
 */

@Database(name = ArticleDatabase.NAME, version = ArticleDatabase.VERSION)
public class ArticleDatabase  {
    public static  final String NAME = "Articles";

    public static final int VERSION = 1;

}
