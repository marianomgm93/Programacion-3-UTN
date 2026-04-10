package org.eduardomango.practicaspringweb.model.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class ErrorDetail {
    private final LocalDateTime timestamp;
    private final String message;
    private final String detail;
}
