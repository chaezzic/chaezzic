package service;

import chaezzic.chaezzicspring.ChaezzicSpringApplication;
import chaezzic.chaezzicspring.domain.User;
import chaezzic.chaezzicspring.repository.MemoryUserRepository;
import chaezzic.chaezzicspring.repository.UserRepository;
import chaezzic.chaezzicspring.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ChaezzicSpringApplication.class)
@Transactional
public class UserServiceIntegrationTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        User user = new User();
        user.setName("hello");

        //when
        Long saveId = userService.join(user);

        //then
        User findUser = userRepository.findById(saveId).get();
        assertEquals(user.getName(), findUser.getName());

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        User user1 = new User();
        user1.setName("spring");

        User user2 = new User();
        user2.setName("spring");

        //when
        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> userService.join(user2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

    }
}
