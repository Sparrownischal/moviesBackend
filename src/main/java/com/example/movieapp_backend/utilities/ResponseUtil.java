package com.example.movieapp_backend.utilities;

import com.example.movieapp_backend.models.MoviesModel;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class ResponseUtil {

    public static <T> ResponseEntity<Object> createApiResponse(String message, List<T> data) {
        ApiResponse<T> response = new ApiResponse<>(message, data);
        return ResponseEntity.ok(response);
    }

    static class ApiResponse<T> {
        private final String msg;
        private final List<T> data;

        public ApiResponse(String msg, List<T> data) {
            this.msg = msg;
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public List<T> getData() {
            return data;
        }
    }
}
