package com.kush.replaceme.controller.dto.response;

public record ValidationFailedDto(
        String field,
        String message
) {

}