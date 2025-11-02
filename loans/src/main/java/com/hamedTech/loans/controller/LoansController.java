package com.hamedTech.loans.controller;


import com.hamedTech.loans.constants.LoansConstants;
import com.hamedTech.loans.dto.ErrorResponseDto;
import com.hamedTech.loans.dto.LoansDto;
import com.hamedTech.loans.dto.ResponseDto;
import com.hamedTech.loans.service.ILoansService;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(
        name = "CRUD REST APIS for Loans in BANK",
        description = "CRUD REST APIS in accounts to create, fetch, update and delete Loans details"
)
public class LoansController {


    private final ILoansService loansService;


    @Operation(
            summary = "Create a new Loan",
            description = "Create a new Loan in the database"
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
    public ResponseEntity<ResponseDto> createLoan(@RequestParam
                                                      @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number should be 10 digits")
                                                      String mobileNumber){

        loansService.createLoan(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));

    }

    @Operation(
            summary = "Fetch a Loan",
            description = "Fetch a Loan from the database"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam
                                                     @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits.")
                                                     String mobileNumber){
        LoansDto loansDto = loansService.fetchLoanDetails(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansDto);
    }

    @Operation(
            summary = "update a Loan",
            description = "update a loan inside database based on LounNumber"
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
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoansDto loansDto){

        boolean isUpdated = loansService.updateLoanDetails(loansDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
        }

    }

    @Operation(
            summary = "update a Loan",
            description = "update a loan inside database based on LounNumber"
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
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam
                                                         @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number should be 10 digits")
                                                         String mobileNumber){
        boolean isDeleted = loansService.deleteLoanDetails(mobileNumber);

        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
        }
    }


}
