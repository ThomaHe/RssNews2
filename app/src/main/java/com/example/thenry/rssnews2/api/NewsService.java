package com.example.thenry.rssnews2.api;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by thenry on 22/02/2017.
 */

public interface NewsService {

    @GET("/rss/une.xml")
    Call<RssFeed> loadRssFeed();
}
