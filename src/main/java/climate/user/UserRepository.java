package climate.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);

    @Query("select u.password from User u where u.name = ?1")
    String findPasswordByName(String name);

}
