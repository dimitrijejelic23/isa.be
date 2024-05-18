package rs.ac.singidunum.bg.vezbe1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs.ac.singidunum.bg.vezbe1.entities.User;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE fist_name LIKE (%:firstName%)")
    List<User> findAllByFirstName(@Param("firstName") String firstName);
}
