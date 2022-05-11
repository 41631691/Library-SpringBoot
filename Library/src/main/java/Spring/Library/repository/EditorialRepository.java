package Spring.Library.repository;

import Spring.Library.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

    @Modifying
    @Query("UPDATE Publisher p SET p.deleted = false WHERE p.id = ?1")
    void enableById(Integer id);

    Optional<Editorial> findByName(String name);

    boolean existsByName(String name);
}
