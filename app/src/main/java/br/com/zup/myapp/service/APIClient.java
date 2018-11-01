package br.com.zup.myapp.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private Context mContext;
    private static APIClient mInstance;
    private Retrofit mRetrofit;
    private OkHttpClient mClient;

    public synchronized static APIClient getInstance() {
        return mInstance;
    }

    public APIClient(@NonNull Context context, @NonNull String baseUrl) {
        mInstance = this;
        this.mContext = context;
        try {
            mClient = getClient();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder()
                .setLenient()
                .setDateFormat("dd-MM-yyyy HH:mm:ss")
                .create();

        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(mClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public OkHttpClient getClient() {
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(getLoggingInterceptor())
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .build();
    }


    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor mLogging = new HttpLoggingInterceptor();
        mLogging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return mLogging;
    }
}
