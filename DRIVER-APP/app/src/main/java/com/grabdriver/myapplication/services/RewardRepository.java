package com.grabdriver.myapplication.services;

import android.content.Context;

import com.grabdriver.myapplication.models.ApiResponse;
import com.grabdriver.myapplication.models.Reward;

import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class RewardRepository extends ApiRepository {

    public RewardRepository(Context context) {
        super(context);
    }

    // Lấy danh sách quà thưởng hiện có
    public void getAvailableRewards(NetworkCallback<List<Reward>> callback) {
        Call<ApiResponse<List<Reward>>> call = getApiService().getAvailableRewards();
        executeCall(call, callback);
    }
    
    // Lấy danh sách quà thưởng đã nhận
    public void getClaimedRewards(NetworkCallback<List<Reward>> callback) {
        Call<ApiResponse<List<Reward>>> call = getApiService().getClaimedRewards();
        executeCall(call, callback);
    }
    
    // Nhận quà thưởng
    public void claimReward(long rewardId, NetworkCallback<Reward> callback) {
        Call<ApiResponse<Reward>> call = getApiService().claimReward(rewardId);
        executeCall(call, callback);
    }
    
    // Lấy tiến độ quà thưởng
    public void getRewardProgress(NetworkCallback<Map<String, Integer>> callback) {
        Call<ApiResponse<Map<String, Integer>>> call = getApiService().getRewardProgress();
        executeCall(call, callback);
    }
} 