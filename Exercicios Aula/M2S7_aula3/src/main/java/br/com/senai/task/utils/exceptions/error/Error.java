package br.com.senai.task.utils.exceptions.error;

import org.springframework.http.HttpStatus;

public class Error {
    private String message;
    private String field;
    private String reason;
    private HttpStatus statusCode;

    public Error() {
    }

    public Error(String message, String field, String reason, HttpStatus statusCode) {
        this.message = message;
        this.field = field;
        this.reason = reason;
        this.statusCode = statusCode;
    }

    public Error(String message, String reason, HttpStatus statusCode) {
        this.message = message;
        this.reason = reason;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
    
}
