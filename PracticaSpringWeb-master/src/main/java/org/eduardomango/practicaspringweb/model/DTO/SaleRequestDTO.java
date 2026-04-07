package org.eduardomango.practicaspringweb.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class SaleRequestDTO {
    @NonNull
    private Long idProduct;
    @NonNull
    private Long idUser;
    @NonNull
    private Long quantity;
}
