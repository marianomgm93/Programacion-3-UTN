package org.eduardomango.practicaspringweb.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.NoSuchElementException;


@Getter
public class UserNotFoundException extends NoSuchElementException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
    }
}
