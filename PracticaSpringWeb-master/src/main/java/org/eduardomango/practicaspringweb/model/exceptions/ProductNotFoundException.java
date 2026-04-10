package org.eduardomango.practicaspringweb.model.exceptions;

import lombok.Getter;

import java.util.NoSuchElementException;

@Getter
public class ProductNotFoundException extends NoSuchElementException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() {
    }
}
