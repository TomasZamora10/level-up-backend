package Level_Up_backend.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "USUARIO")
@Data
@Getter @Setter @ToString @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "email", unique = true, nullable = false, length = 150)
    private String email; // Usado como username

    @Column(name = "password", nullable = false, length = 255)
    private String password; // Debe estar HASHEADA

    // El rol define los permisos (Administrador, Vendedor, Cliente) [cite: 154, 156, 157, 161]
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false, length = 50)
    private RolEnum rol; // Usaremos un Enum para roles

    // Relación OneToMany: Un Usuario (Cliente) tiene muchas Boletas
    @OneToMany(mappedBy = "usuario")
    private List<Boleta> boletas;
}
