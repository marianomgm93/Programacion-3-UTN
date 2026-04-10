package org.eduardomango.practicaspringweb.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.xml.xpath.XPathException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({SaleNotFoundException.class,
            ProductNotFoundException.class,
            UserNotFoundException.class})
    public ResponseEntity<ErrorDetail> handleSaleNotFound(NoSuchElementException e, WebRequest req){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorDetail.builder().timestamp(LocalDateTime.now())
                        .message(e.getMessage())
                        .detail(req.getDescription(false))
                        .build());
    }
    /*
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User not found");
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Product not found");
    }

     */
}
