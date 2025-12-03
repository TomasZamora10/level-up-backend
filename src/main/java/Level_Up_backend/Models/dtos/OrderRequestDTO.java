package Level_Up_backend.Models.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {
    @NotNull(message = "El ID del cliente no puede ser nulo")
    private Long clientId;

    @NotEmpty(message = "La dirección de envío es obligatoria")
    private String direccionEnvio;

    @NotNull(message = "El indicador de descuento DUOC es obligatorio")
    private Boolean aplicaDescuentoDuoc;

    @Valid
    @NotEmpty(message = "La orden debe contener al menos un producto")
    private List<ItemDTO> items;
}
