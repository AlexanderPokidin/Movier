package com.pokidin.a.movier;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessageBuilder {
    private static final String TAG = "MessageBuilder";
    private static final String URL = "https://rawgit.com/startandroid/data/master/messages/";

    public void calling() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MessagesApi mMessagesApi = mRetrofit.create(MessagesApi.class);

        Call<List<Message>> messages = mMessagesApi.messages();
        messages.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                Log.i(TAG, "Success: " + response.body().size());
                Log.i(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.e(TAG, "" + t);

            }
        });

    }


}
