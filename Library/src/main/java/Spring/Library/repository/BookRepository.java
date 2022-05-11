package Spring.Library.repository;

import Spring.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Query("UPDATE Book b SET b.deleted = false WHERE b.id = ?1")
    void enableById(Integer id);

    Optional<Book> findByName(String name);

    boolean existsByName(String name);
}
