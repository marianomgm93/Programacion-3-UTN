package org.eduardomango.practicaspringweb.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.NoSuchElementException;

@Getter
public class SaleNotFoundException extends NoSuchElementException {

    public SaleNotFoundException(String message) {
        super(message);
    }
    public SaleNotFoundException(){

    }
}
