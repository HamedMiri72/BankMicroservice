package com.hamedTech.cards.controller;


import com.hamedTech.cards.constant.CardConstants;
import com.hamedTech.cards.dto.CardDto;
import com.hamedTech.cards.dto.ErrorResponseDto;
import com.hamedTech.cards.dto.ResponseDto;
import com.hamedTech.cards.service.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
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
        name = "Cards Controller",
        description = "Cards Controller"
)
public class CardsController {

    private final ICardsService cardsService;

    @Operation(
            summary = "Create a new card",
            description = "Create a new card"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Card created successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    }

    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam
                                                      @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                      String mobileNumber){

        cardsService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardConstants.STATUS_201, CardConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Read card REST API",
            description = "REST API to read card details"
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
                            schema = @Schema(implementation = ErrorResponseDto.class)
                            ,mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    }

    )
    @GetMapping("/fetch")
    public ResponseEntity<CardDto> fetchCardsDetails(@RequestParam
                                                         @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                         String mobileNumber){

        CardDto cardDto = cardsService.fetchCardDetails(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardDto);
    }


    @Operation(
            summary = "Update card REST API",
            description = "REST API to update card details"
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
    }

    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCadsDetails(@Valid @RequestBody CardDto cardDto){

        boolean isUpdated = cardsService.updateCardDetails(cardDto);

        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardConstants.STATUS_417, CardConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete card REST API",
            description = "REST API to delete card details"
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
    }

    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCardDetails(@RequestParam
                                                             @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                             String mobileNumber){

        boolean isDeleted = cardsService.deleteCardDetails(mobileNumber);

        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardConstants.STATUS_417, CardConstants.MESSAGE_417_DELETE));
        }
    }


}
