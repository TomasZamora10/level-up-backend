package Level_Up_backend.repositories;


import Level_Up_backend.Models.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
    /**
     * Opcional: Buscar todas las boletas de un usuario específico.
     */
    List<Boleta> findByUsuarioIdUsuario(Integer idUsuario);
}
