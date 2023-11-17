package chaezzic.chaezzicspring.config;

//import chaezzic.chaezzicspring.repository.MemoryUserRepository;
import chaezzic.chaezzicspring.repository.UserRepository;
import chaezzic.chaezzicspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }

//    @Bean
//    public UserRepository userRepository() {
//        return new JpaUserRepository(em);
//    }
}
