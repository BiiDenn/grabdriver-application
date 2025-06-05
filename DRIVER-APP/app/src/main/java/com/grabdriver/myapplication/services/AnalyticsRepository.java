package com.grabdriver.myapplication.services;

import android.content.Context;

import com.grabdriver.myapplication.models.ApiResponse;

import java.util.Map;

import retrofit2.Call;

public class AnalyticsRepository extends ApiRepository {

    public AnalyticsRepository(Context context) {
        super(context);
    }

    // Lấy thống kê hiệu suất làm việc
    public void getPerformanceAnalytics(String period, NetworkCallback<Map<String, Object>> callback) {
        Call<ApiResponse<Map<String, Object>>> call = getApiService().getPerformanceAnalytics(period);
        executeCall(call, callback);
    }
    
    // Lấy thống kê thu nhập
    public void getEarningsAnalytics(String period, NetworkCallback<Map<String, Object>> callback) {
        Call<ApiResponse<Map<String, Object>>> call = getApiService().getEarningsAnalytics(period);
        executeCall(call, callback);
    }
    
    // Lấy thống kê đơn hàng
    public void getOrdersAnalytics(String period, NetworkCallback<Map<String, Object>> callback) {
        Call<ApiResponse<Map<String, Object>>> call = getApiService().getOrdersAnalytics(period);
        executeCall(call, callback);
    }
} 