package chaezzic.chaezzicspring.config;

//import chaezzic.chaezzicspring.repository.MemoryUserRepository;
import chaezzic.chaezzicspring.repository.JobRepository;
import chaezzic.chaezzicspring.repository.UserRepository;
import chaezzic.chaezzicspring.service.JobService;
import chaezzic.chaezzicspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository, JobRepository jobRepository) {
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }

    @Bean
    public JobService jobService() {
        return new JobService(jobRepository);
    }

//    @Bean
//    public UserRepository userRepository() {
//        return new JpaUserRepository(em);
//    }
}
