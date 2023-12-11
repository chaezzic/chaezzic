package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long>, JobRepositoryCustom {
    Job save(Job job);
}
