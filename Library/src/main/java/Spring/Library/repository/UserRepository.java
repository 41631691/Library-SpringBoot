package Spring.Library.repository;

import Spring.Library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("UPDATE User u SET u.deleted = false WHERE u.id = ?1")
    void enableById(Integer id);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
