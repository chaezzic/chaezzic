package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    List<User> findAll();
}
