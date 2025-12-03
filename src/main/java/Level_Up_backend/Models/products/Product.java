package Level_Up_backend.Models.products;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El nombre del producto no puede ser nulo")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "La categoría no puede ser nula")
    private String categoria;

    @Min(value = 0, message = "El precio debe ser cero o positivo")
    private Integer precio;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "La descripción no puede ser nula")
    private String descripcion;

    private String imagen;

    private Integer stock = 0;
}
