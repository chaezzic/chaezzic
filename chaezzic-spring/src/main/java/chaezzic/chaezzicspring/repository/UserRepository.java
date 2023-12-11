package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom{

    User save(User user);

    Optional<User> findById(Long id);
}
