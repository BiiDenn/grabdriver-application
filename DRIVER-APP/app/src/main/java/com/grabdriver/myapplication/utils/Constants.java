package com.grabdriver.myapplication.utils;

public class Constants {
    // Status code cho đơn hàng
    public static final class OrderStatus {
        public static final String WAITING = "WAITING";           // Đang chờ tài xế chấp nhận
        public static final String ACCEPTED = "ACCEPTED";         // Tài xế đã chấp nhận
        public static final String PICKING_UP = "PICKING_UP";     // Tài xế đang đi lấy đồ ăn
        public static final String PICKED_UP = "PICKED_UP";       // Tài xế đã lấy đồ ăn
        public static final String SHIPPING = "SHIPPING";         // Đang giao hàng
        public static final String DELIVERED = "DELIVERED";       // Đã giao hàng
        public static final String CANCELLED = "CANCELLED";       // Đã hủy
        public static final String REJECTED = "REJECTED";         // Bị từ chối
    }
    
    // Các loại giao dịch trong ví
    public static final class TransactionType {
        public static final String EARNING = "EARNING";           // Thu nhập từ việc giao hàng
        public static final String TIP = "TIP";                   // Tiền tip từ khách hàng
        public static final String BONUS = "BONUS";               // Tiền thưởng từ hệ thống
        public static final String TOP_UP = "TOP_UP";             // Nạp tiền
        public static final String COMMISSION = "COMMISSION";     // Hoa hồng trả cho công ty
        public static final String COD_DEPOSIT = "COD_DEPOSIT";   // Tiền thu hộ COD
        public static final String WITHDRAW = "WITHDRAW";         // Rút tiền
    }
    
    // Loại phương tiện
    public static final class VehicleType {
        public static final String MOTORBIKE = "Xe máy";
        public static final String BIKE = "Xe đạp";
        public static final String CAR = "Ô tô";
    }
    
    // Thời kỳ thống kê
    public static final class Period {
        public static final String TODAY = "today";
        public static final String WEEK = "week";
        public static final String MONTH = "month";
        public static final String YEAR = "year";
    }
    
    // Các loại thông báo
    public static final class NotificationType {
        public static final String NEW_ORDER = "NEW_ORDER";
        public static final String ORDER_UPDATE = "ORDER_UPDATE";
        public static final String WALLET_UPDATE = "WALLET_UPDATE";
        public static final String SYSTEM = "SYSTEM";
    }
    
    // API Error codes
    public static final class ErrorCode {
        public static final int UNAUTHORIZED = 401;
        public static final int FORBIDDEN = 403;
        public static final int NOT_FOUND = 404;
        public static final int BAD_REQUEST = 400;
        public static final int SERVER_ERROR = 500;
    }
    
    // Intent codes
    public static final int REQUEST_CODE_LOCATION_PERMISSION = 1001;
    public static final int REQUEST_CODE_IMAGE_PICK = 1002;
} 