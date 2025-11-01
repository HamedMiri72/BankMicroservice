package com.hamedTech.accounts.controller;

import com.hamedTech.accounts.constants.AccountsConstants;
import com.hamedTech.accounts.dto.CustomerDto;
import com.hamedTech.accounts.dto.ErrorResponseDto;
import com.hamedTech.accounts.dto.ResponseDto;
import com.hamedTech.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(
        name = "CRUD REST APIS for accounts in BANK",
        description = "CRUD REST APIS in accounts to create, fetch, update and delete account details"
)
public class AccountsController {

    private final IAccountService iAccountService;

    @Operation(
            summary = "Create account REST API",
            description = "REST API to create new customer and account inside BANK"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http status created"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto request){

        iAccountService.createAccounts(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Read account REST API",
            description = "REST API to read customer and account details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode ="200",
                    description ="Http status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                            ,mediaType = MediaType.APPLICATION_JSON_VALUE)
            )

})
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                               String mobileNumber){

        CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @Operation(
            summary = "UPDATE account REST API",
            description = "REST API to update customer and account details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Exception failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status internal server error",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponseDto.class)
                            , mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto){

        boolean isUpdated = iAccountService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }

    }

    @Operation(
            summary = "DELETE account REST API",
            description = "REST API to DELETE customer and account details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Exception failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status internal server error",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponseDto.class)
                    ,mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam
                                                         @Pattern(regexp = "^[0-9]{10}$", message = "mobile number should be 10 digits")
                                                         String mobileNumber){

       boolean isDeleted =  iAccountService.deleteAccount(mobileNumber);

       if(isDeleted){
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
       }else{
           return ResponseEntity
                   .status(HttpStatus.EXPECTATION_FAILED)
                   .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
       }
    }

}
