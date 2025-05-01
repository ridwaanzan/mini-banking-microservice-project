package id.co.mybank.dto;

public class ApiResponse<T> {
    public int statusCode;
    public boolean success;
    public String message;
    public T data;

    public ApiResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.success = true;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.success = false;
        this.message = message;
        this.data = null;
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, message, data);
    }

    public static <T> ApiResponse<T> error(int statusCode, String message) {
        return new ApiResponse<>(statusCode, message);
    }
}
