package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findByUserId(Long id);
}
