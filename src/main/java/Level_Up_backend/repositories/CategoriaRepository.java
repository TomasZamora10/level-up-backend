package Level_Up_backend.repositories;


import Level_Up_backend.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    /**
     * Opcional: Ejemplo de un método personalizado.
     */
    Optional<Categoria> findByNombre(String nombre);

}
