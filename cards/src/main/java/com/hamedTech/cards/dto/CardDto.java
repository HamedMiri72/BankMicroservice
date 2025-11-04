package com.hamedTech.cards.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private String mobileNumber;

    private String cardNumber;

    private String cardType;

    @PositiveOrZero(message = "total limit can not be a negative number")
    private int totalLimit;

    @PositiveOrZero(message = "can not be negative")
    private int amountUsed;

    @PositiveOrZero(message = "can not be negative")
    private int availableAmount;
}
