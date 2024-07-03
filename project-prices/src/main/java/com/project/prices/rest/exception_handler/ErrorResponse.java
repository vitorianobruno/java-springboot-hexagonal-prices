package com.project.prices.rest.exception_handler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private int httpStatus;

    private String type, message, clazz, method;

    private int line;

}
