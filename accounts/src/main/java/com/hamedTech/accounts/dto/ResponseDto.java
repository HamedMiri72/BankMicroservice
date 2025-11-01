package com.hamedTech.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "response",
        description = "Schema to hold response information"
)
public class ResponseDto {

    @Schema(
            description = "Status code"
    )
    private String statusCode;
    @Schema(
            description = "Status message"
    )
    private String StatusMsg;
}
