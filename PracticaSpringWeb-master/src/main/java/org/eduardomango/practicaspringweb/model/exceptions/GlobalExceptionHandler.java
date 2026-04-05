package org.eduardomango.practicaspringweb.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<String> handleSaleNotFound(SaleNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Sale not found");
    }
}
