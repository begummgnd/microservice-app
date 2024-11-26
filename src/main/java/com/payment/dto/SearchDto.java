package com.payment.dto;

import com.payment.constant.MessageConstants;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchDto {

    @NotBlank(message = MessageConstants.RENTACAR_INCORRECT_CHARACTER_LENGTH)
    private String number;
}
