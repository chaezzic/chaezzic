package chaezzic.chaezzicspring.service;

import chaezzic.chaezzicspring.repository.JobSkillsRepository;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Data
public class JobSkillsService {
    private final JobSkillsRepository jobSkillsRepository;

    public JobSkillsService(JobSkillsRepository jobSkillsRepository){
        this.jobSkillsRepository = jobSkillsRepository;
    }
}
