package com.manuBank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "It is response of particular endpoint",
        description = "It is how exactly the response should be"
)
public class ResponseDto {

    @Schema(
            description = "It is the status code of particular response"
    )
    private String statusCode;
    @Schema(
            description = "It is the status message of particular response"
    )
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
