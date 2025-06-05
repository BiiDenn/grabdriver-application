package com.grabdriver.myapplication.services;

import android.content.Context;

import com.grabdriver.myapplication.models.ApiResponse;
import com.grabdriver.myapplication.models.FeedbackRequest;

import java.util.Map;

import retrofit2.Call;

public class SystemRepository extends ApiRepository {

    public SystemRepository(Context context) {
        super(context);
    }

    // Kiểm tra phiên bản ứng dụng
    public void checkAppVersion(String currentVersion, NetworkCallback<Map<String, String>> callback) {
        Call<ApiResponse<Map<String, String>>> call = getApiService().checkVersion(currentVersion);
        executeCall(call, callback);
    }
    
    // Gửi phản hồi
    public void submitFeedback(String subject, String message, String category, String priority, NetworkCallback<Void> callback) {
        FeedbackRequest request = new FeedbackRequest(subject, message, category, priority);
        Call<ApiResponse<Void>> call = getApiService().submitFeedback(request);
        executeCall(call, callback);
    }
    
    // Lấy thông tin hỗ trợ
    public void getSupportInfo(NetworkCallback<Map<String, String>> callback) {
        Call<ApiResponse<Map<String, String>>> call = getApiService().getSupportInfo();
        executeCall(call, callback);
    }
} 