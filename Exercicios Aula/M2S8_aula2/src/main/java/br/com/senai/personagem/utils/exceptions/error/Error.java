package br.com.senai.personagem.utils.exceptions.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class Error {

    private HttpStatus statusCode;
    private String message;
    private final List<ErrorDetail> errors = new ArrayList<>();

    public Error() {
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message =  HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }

    public Error(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Error(String message) {
        this.statusCode = HttpStatus.BAD_REQUEST;
        this.message = message;
    }

    public Error(String message, String locationField) {
        this.statusCode = HttpStatus.BAD_REQUEST;
        this.message = message;
        addDetail(null, locationField);
    }

    public Error(HttpStatus statusCode, String message, Throwable cause) {
        this.statusCode = statusCode;
        this.message = message;
        addDetail(cause, null);
    }

    public Error(HttpStatus statusCode, String message, Throwable cause, String locationField) {
        this.statusCode = statusCode;
        this.message = message;
        addDetail(cause, locationField);
    }

    public void addDetail(Throwable cause, String locationField) {
        ErrorDetail detail = ErrorDetail.builder()
            .reason(cause != null ? cause.getCause().toString() : "")
            .locationField(locationField != null ? locationField : "")
            .build();
        errors.add(detail);
    }
}
