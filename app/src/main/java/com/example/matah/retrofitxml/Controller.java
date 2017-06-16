package com.example.matah.retrofitxml;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by matah on 07/06/2017.
 */

public class Controller implements Callback<RSSFeed> {
    static final String BASE_URL = "http://vogella.com/";

    public void start() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        VogellaAPI vogellaAPI = retrofit.create(VogellaAPI.class);

        Call<RSSFeed> call = vogellaAPI.loadRSSFeed();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<RSSFeed> call, Response<RSSFeed> response) {
        if (response.isSuccessful()) {
            RSSFeed rss = response.body();
            //System.out.println("Channel title: " + rss.getChannelTitle());
            String imp="Channel title: " + rss.getChannelTitle();
            Log.d("imprimir",imp);
            rss.getArticleList().forEach(

                    article -> System.out.println("Title: " + article.getTitle() + " Link: " + article.getLink()));

        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<RSSFeed> call, Throwable t) {
        t.printStackTrace();
    }
}
