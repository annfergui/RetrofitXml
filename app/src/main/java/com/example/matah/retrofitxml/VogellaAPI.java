package com.example.matah.retrofitxml;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by matah on 07/06/2017.
 */

public interface VogellaAPI {
    @GET("article.rss")
    Call<RSSFeed> loadRSSFeed();
}
