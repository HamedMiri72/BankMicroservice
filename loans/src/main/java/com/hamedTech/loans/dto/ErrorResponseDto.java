package com.hamedTech.loans.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "ErrorResponseDto",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path of the request",
            example = "/loans/create"
    )
    private String apiPath;

    @Schema(
            description = "Error code of the request",
            example = "500"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message of the request",
            example = "Internal server error"
    )
    private String errorMessage;

    @Schema(
            description = "Error time of the request",
            example = "2022-01-01T00:00:00"
    )
    private LocalDateTime errorTime;
}
