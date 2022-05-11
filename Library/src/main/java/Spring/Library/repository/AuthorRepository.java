package Spring.Library.repository;

import Spring.Library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Modifying
    @Query("UPDATE Author a SET a.deleted = false WHERE a.id = ?1")
    void enableById(Integer id);

    Optional<Author> findByName(String name);
    boolean existsByNameAndSurname(String name, String surname);
    boolean existsByName(String name);
}
