package chaezzic.chaezzicspring.service;

import chaezzic.chaezzicspring.repository.SkillRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

}
