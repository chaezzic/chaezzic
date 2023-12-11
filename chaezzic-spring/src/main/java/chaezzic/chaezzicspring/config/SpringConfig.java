package chaezzic.chaezzicspring.config;

import chaezzic.chaezzicspring.repository.JobRepository;
import chaezzic.chaezzicspring.repository.JobSkillsRepository;
import chaezzic.chaezzicspring.repository.SkillRepository;
import chaezzic.chaezzicspring.repository.UserRepository;
import chaezzic.chaezzicspring.service.JobService;
import chaezzic.chaezzicspring.service.JobSkillsService;
import chaezzic.chaezzicspring.service.SkillService;
import chaezzic.chaezzicspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final SkillRepository skillRepository;
    private final JobSkillsRepository jobSkillsRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository, JobRepository jobRepository, SkillRepository skillRepository, JobSkillsRepository jobSkillsRepository) {
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.skillRepository = skillRepository;
        this.jobSkillsRepository = jobSkillsRepository;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }

    @Bean
    public JobService jobService() {
        return new JobService(jobRepository);
    }

    @Bean
    public SkillService skillService(){
        return new SkillService(skillRepository);
    }

    @Bean
    public JobSkillsService jobSkillsService(){
        return new JobSkillsService(jobSkillsRepository);
    }

//    @Bean
//    public UserRepository userRepository() {
//        return new JpaUserRepository(em);
//    }
}
