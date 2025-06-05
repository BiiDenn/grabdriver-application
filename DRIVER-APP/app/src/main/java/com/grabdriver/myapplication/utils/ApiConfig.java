package com.grabdriver.myapplication.utils;

public class ApiConfig {
    public static final String BASE_URL = "http://localhost:6969/grab/";
    public static final String API_PATH = "api/driver/";
    public static final int CONNECT_TIMEOUT = 60;
    public static final int READ_TIMEOUT = 60;
    public static final int WRITE_TIMEOUT = 60;
    
    // API Endpoints
    public static final class Endpoints {
        // Authentication
        public static final String LOGIN = API_PATH + "login";
        public static final String LOGOUT = API_PATH + "logout";
        public static final String VERIFY_TOKEN = API_PATH + "verify-token";
        
        // Location & Tracking
        public static final String UPDATE_LOCATION = API_PATH + "location/update";
        public static final String GET_CURRENT_LOCATION = API_PATH + "location/current";
        
        // Order Management
        public static final String AVAILABLE_ORDERS = API_PATH + "orders/available";
        public static final String ASSIGNED_ORDERS = API_PATH + "orders/assigned";
        public static final String ORDER_HISTORY = API_PATH + "orders/history";
        public static final String ORDER_DETAILS = API_PATH + "orders/{orderId}/details";
        public static final String ACCEPT_ORDER = API_PATH + "orders/{orderId}/accept";
        public static final String REJECT_ORDER = API_PATH + "orders/{orderId}/reject";
        public static final String UPDATE_ORDER_STATUS = API_PATH + "orders/{orderId}/status";
        public static final String CONFIRM_PICKUP = API_PATH + "orders/{orderId}/pickup-confirm";
        public static final String CONFIRM_DELIVERY = API_PATH + "orders/{orderId}/delivery-confirm";
        public static final String PENDING_ORDERS_COUNT = API_PATH + "orders/pending-count";
        
        // Profile Management
        public static final String PROFILE = API_PATH + "profile";
        public static final String PROFILE_STATS = API_PATH + "profile/stats";
        public static final String UPLOAD_AVATAR = API_PATH + "profile/avatar";
        
        // Wallet & Financial
        public static final String WALLET = API_PATH + "wallet";
        public static final String TRANSACTIONS = API_PATH + "wallet/transactions";
        public static final String TRANSACTIONS_BY_TYPE = API_PATH + "wallet/transactions/type";
        public static final String WITHDRAW = API_PATH + "wallet/withdraw";
        public static final String EARNINGS = API_PATH + "wallet/earnings";
        public static final String CAN_WITHDRAW = API_PATH + "wallet/can-withdraw";
        
        // Rewards System
        public static final String AVAILABLE_REWARDS = API_PATH + "rewards/available";
        public static final String CLAIMED_REWARDS = API_PATH + "rewards/claimed";
        public static final String CLAIM_REWARD = API_PATH + "rewards/{rewardId}/claim";
        public static final String REWARD_PROGRESS = API_PATH + "rewards/progress";
        
        // Analytics
        public static final String PERFORMANCE_ANALYTICS = API_PATH + "analytics/performance";
        public static final String EARNINGS_ANALYTICS = API_PATH + "analytics/earnings";
        public static final String ORDERS_ANALYTICS = API_PATH + "analytics/orders";
        
        // System Utilities
        public static final String CHECK_VERSION = API_PATH + "system/version";
        public static final String SUBMIT_FEEDBACK = API_PATH + "system/feedback";
        public static final String GET_SUPPORT = API_PATH + "system/support";
    }
} 