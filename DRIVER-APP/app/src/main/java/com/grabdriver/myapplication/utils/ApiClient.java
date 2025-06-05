package com.grabdriver.myapplication.utils;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {
        if (retrofit == null) {
            // Tạo interceptor để log thông tin request/response
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Tạo session manager để lấy token
            SessionManager sessionManager = new SessionManager(context);

            // Tạo OkHttpClient với interceptor cho authentication
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(chain -> {
                        Request originalRequest = chain.request();
                        
                        // Kiểm tra nếu người dùng đã đăng nhập
                        String token = sessionManager.getToken();
                        if (token != null) {
                            Request.Builder requestBuilder = originalRequest.newBuilder()
                                    .header("Authorization", "Bearer " + token)
                                    .header("Accept", "application/json")
                                    .method(originalRequest.method(), originalRequest.body());
                            
                            Request request = requestBuilder.build();
                            return chain.proceed(request);
                        }
                        
                        return chain.proceed(originalRequest);
                    })
                    .connectTimeout(ApiConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(ApiConfig.READ_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(ApiConfig.WRITE_TIMEOUT, TimeUnit.SECONDS);

            OkHttpClient httpClient = httpClientBuilder.build();

            // Tạo Retrofit instance
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        
        return retrofit;
    }
} 