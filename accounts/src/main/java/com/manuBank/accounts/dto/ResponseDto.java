package com.manuBank.accounts.dto;

public class ResponseDto {

    private String statusCode;
    private String statusMessage;

    public ResponseDto() {
    }

    public ResponseDto(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "statusCode='" + statusCode + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }


}
