package Level_Up_backend.repositories;

import Level_Up_backend.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    /**
     * Requerido por Spring Security: busca un usuario por su email (username).
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Opcional: Para validar que el email no se repita en el registro.
     */
    boolean existsByEmail(String email);
}
