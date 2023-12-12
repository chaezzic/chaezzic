package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long>{

    Skill save(Skill skill);
}
