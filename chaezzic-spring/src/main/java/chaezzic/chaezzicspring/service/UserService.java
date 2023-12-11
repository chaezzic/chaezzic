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
        userRepository.findById(user.getId())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    // 전체 회원 조회
    public List<User> findMembers() {
        return userRepository.findAll();
    }

    // getTestUser와 같은 기능
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    //query로 findOne 기능 재구현한 함수
    public Optional<User> getUser(Long id){
        return userRepository.findByUserId(id);
    }

}