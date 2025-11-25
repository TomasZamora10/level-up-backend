package Level_Up_backend.repositories;

import Level_Up_backend.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    /**
     * Opcional: Ejemplo de un método personalizado para buscar productos por nombre.
     */
    List<Producto> findByNombreContaining(String nombre);
}
