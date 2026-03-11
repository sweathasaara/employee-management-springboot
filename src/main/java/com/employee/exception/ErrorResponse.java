package com.employee.exception;

public class ErrorResponse {

    private int status;
    private String error;

    public ErrorResponse(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}