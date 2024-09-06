package com.williamsaran.bancojaver;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    Gson gson = new Gson();

    @ExceptionHandler(FeignException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public Object handleFeignException(FeignException e) {
        JsonParser.parseString(e.contentUTF8());
        return gson.fromJson(e.contentUTF8(), Object.class);
    }
}
