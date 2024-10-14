package org.user_service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.user_service.Payload.ApiResponse;

@RestControllerAdvice // Iss annotation se ye poore project ka centralized exception bnn jayega...
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class) // Agr poore project mai ResourceNotFoundException aayegi toh ye neeche waala method chl jaayega...
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception){
        String message = exception.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
