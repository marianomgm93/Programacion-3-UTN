package org.eduardomango.practicaspringweb.model.DTO;



import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class SaleRequestDTO {
    @NotBlank(message = "Product id is required")
    private Long idProduct;
    @NotBlank(message = "User id is required")
    private Long idUser;
    @NotBlank(message = "Quantity is required")
    private Long quantity;
}
