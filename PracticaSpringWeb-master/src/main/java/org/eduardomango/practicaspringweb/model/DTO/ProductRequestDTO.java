package org.eduardomango.practicaspringweb.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDTO {
    @NotBlank
    private String name;
    @NotNull
    @PositiveOrZero
    private double price;
    @NotBlank
    private String description;
}
