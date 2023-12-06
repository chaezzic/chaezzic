package chaezzic.chaezzicspring.service;

import chaezzic.chaezzicspring.repository.JobSkillsRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JobSkillsService {
    private final JobSkillsRepository jobSkillsRepository;

    public JobSkillsService(JobSkillsRepository jobSkillsRepository){
        this.jobSkillsRepository = jobSkillsRepository;
    }
}
