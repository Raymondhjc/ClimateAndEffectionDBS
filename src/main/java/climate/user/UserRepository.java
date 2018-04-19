package climate.user;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Users, Integer> {

    Users findByName(String name);
}
