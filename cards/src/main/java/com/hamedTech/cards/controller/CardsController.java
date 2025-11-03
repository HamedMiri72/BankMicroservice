package com.hamedTech.cards.controller;


import com.hamedTech.cards.constant.CardConstants;
import com.hamedTech.cards.dto.CardDto;
import com.hamedTech.cards.dto.ResponseDto;
import com.hamedTech.cards.entity.Card;
import com.hamedTech.cards.service.ICardsService;
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
public class CardsController {

    private final ICardsService cardsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam
                                                      @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                      String mobileNumber){

        cardsService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardConstants.STATUS_201, CardConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardDto> fetchCardsDetails(@RequestParam
                                                         @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                         String mobileNumber){

        CardDto cardDto = cardsService.fetchCardDetails(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCadsDetails(@RequestBody CardDto cardDto){

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


}
