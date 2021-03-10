package com.cjeronimo.demo.driver.adapter.inbound.rest.payload;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;


@Getter
public class ResponseDTO<T> {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;

    @Nullable
    private T content;

    private ResponseDTO(HttpStatus status, String message, @Nullable T content) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.content = content;
    }


    public static <T> ResponseDTO<T> ok(String message, @Nullable T content) {
        return new ResponseDTO<>(HttpStatus.OK, message, content);
    }


    public static <T> ResponseDTO<T> nok(HttpStatus status, String message) {
        return new ResponseDTO<>(status, message, null);
    }
}
