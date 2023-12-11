package service;

import chaezzic.chaezzicspring.ChaezzicSpringApplication;
import chaezzic.chaezzicspring.domain.*;
import chaezzic.chaezzicspring.repository.JobRepository;
import chaezzic.chaezzicspring.repository.JobSkillsRepository;
import chaezzic.chaezzicspring.repository.SkillRepository;
import chaezzic.chaezzicspring.repository.UserRepository;
import chaezzic.chaezzicspring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ChaezzicSpringApplication.class)
@Transactional
public class UserServiceIntegrationTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired JobRepository jobRepository;
    @Autowired SkillRepository skillRepository;
    @Autowired JobSkillsRepository jobSkillsRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        User user = new User();
        user.setId(1234L);
        user.setName("hello");

        //when
        Long saveId = userService.join(user);

        //then
        User findUser = userRepository.findById(saveId).get();
        assertEquals(user.getName(), findUser.getName());

    }

    @Test
    public void 모든_회원_조회() throws Exception {
        //given
        User user1 = new User();
        user1.setId(1234L);
        user1.setName("spring1");

        User user2 = new User();
        user2.setId(2345L);
        user2.setName("spring2");

        //when
        Long saveId1 = userService.join(user1);
        Long saveId2 = userService.join(user2);

        //then
        List<User> allUser = userRepository.findAll();
        assertEquals(4, allUser.size());
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

    @Test
    public void 사용자_찾기_쿼리_날리기() throws Exception {

        User user = new User();
        user.setId(1234L);
        user.setName("hello");

        //when
        Long saveId = userService.join(user);

        //then
        User findUser = userRepository.findByUserId(saveId)
                        .orElseThrow(() -> new NoSuchElementException("User not found"));
        assertEquals(user.getName(), findUser.getName());

    }

    @Test
    public void 스택_5개_쿼리_날리기() throws Exception {
        //given
        Job job1 = new Job();
        Skill skill1 = new Skill();
        JobSkills jobSkills1 = new JobSkills();
        job1.setJobTitle("Engineer");
        job1.setTitle("spring1");
        job1.setId(12345678L);
        skill1.setName("Java");
        skill1.setId(12L);
        jobSkills1.setJobId(job1.getId());
        jobSkills1.setSkillId(skill1.getId());
        jobSkills1.setId(1234);
        jobRepository.save(job1);
        skillRepository.save(skill1);
        jobSkillsRepository.save(jobSkills1);

        Job job2 = new Job();
        Skill skill2 = new Skill();
        JobSkills jobSkills2 = new JobSkills();
        job2.setJobTitle("Engineer");
        job2.setId(23456789L);
        job2.setTitle("spring2");
        skill2.setName("Python");
        skill2.setId(23L);
        jobSkills2.setJobId(job2.getId());
        jobSkills2.setSkillId(skill2.getId());
        jobSkills2.setId(2345);
        jobRepository.save(job2);
        skillRepository.save(skill2);
        jobSkillsRepository.save(jobSkills2);

        Job job3 = new Job();
        Skill skill3 = new Skill();
        JobSkills jobSkills3 = new JobSkills();
        job3.setJobTitle("Designer");
        job3.setId(34567890L);
        job3.setTitle("spring");
        skill3.setName("UI/UX");
        skill3.setId(34L);
        jobSkills3.setJobId(job3.getId());
        jobSkills3.setSkillId(skill3.getId());
        jobSkills3.setId(3456);
        jobRepository.save(job3);
        skillRepository.save(skill3);
        jobSkillsRepository.save(jobSkills3);

        //when
        List<JobDTO> jobList = jobRepository.findTop5Skills("Engineer");

        //then
        assertEquals(2, jobList.size());

    }
}
