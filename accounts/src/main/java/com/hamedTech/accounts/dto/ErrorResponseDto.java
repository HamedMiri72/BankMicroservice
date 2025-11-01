package com.hamedTech.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "Error ResponseDto",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path",
            example = "/api/v1/accounts/create"
    )
    private String apiPath;
    @Schema(
            description = "HTTP status code"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message showing to the client"
    )
    private String errorMessage;
    @Schema(
            description = "Date and time when error happened"
    )
    private LocalDateTime errorTime;
}
