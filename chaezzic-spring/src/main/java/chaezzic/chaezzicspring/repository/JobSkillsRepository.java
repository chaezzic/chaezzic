package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.JobSkills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSkillsRepository extends JpaRepository<JobSkills, Long> {

    JobSkills save(JobSkills jobSkills);
}
