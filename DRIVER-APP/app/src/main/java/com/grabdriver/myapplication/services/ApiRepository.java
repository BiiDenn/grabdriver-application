package com.grabdriver.myapplication.services;

import android.content.Context;

import com.grabdriver.myapplication.models.ApiResponse;
import com.grabdriver.myapplication.utils.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository {
    private Context context;
    private ApiService apiService;

    public ApiRepository(Context context) {
        this.context = context;
        this.apiService = ApiClient.getClient(context).create(ApiService.class);
    }

    protected ApiService getApiService() {
        return apiService;
    }

    protected <T> void executeCall(Call<ApiResponse<T>> call, NetworkCallback<T> callback) {
        call.enqueue(new Callback<ApiResponse<T>>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<T> apiResponse = response.body();
                    
                    if (apiResponse.isStatus()) {
                        callback.onSuccess(apiResponse.getData());
                    } else {
                        String errorMsg = apiResponse.getError() != null ? apiResponse.getError() : apiResponse.getMessage();
                        callback.onError(errorMsg);
                    }
                } else {
                    String errorMsg = "Lỗi kết nối: " + response.code();
                    callback.onError(errorMsg);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                callback.onError("Lỗi kết nối: " + t.getMessage());
            }
        });
    }

    public interface NetworkCallback<T> {
        void onSuccess(T result);
        void onError(String errorMessage);
    }
} 