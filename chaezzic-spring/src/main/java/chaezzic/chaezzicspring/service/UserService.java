package chaezzic.chaezzicspring.service;

import chaezzic.chaezzicspring.domain.User;
import chaezzic.chaezzicspring.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입 기능 구현
    public Long join(User user) {
        validateDuplicateMember(user);
        userRepository.save(user);

        return user.getId();
    }

    private void validateDuplicateMember(User user) {
        userRepository.findByName(user.getName())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    // 전체 회원 조회
    public List<User> findMembers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }

}