package Level_Up_backend.repositories;

import Level_Up_backend.Models.DetalleBoleta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleBoletaRepository {
    /**
     * Opcional: Buscar todos los detalles de una boleta específica.
     */
    List<DetalleBoleta> findByBoletaIdBoleta(Integer idBoleta);
}
