package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaJobRepository extends JpaRepository<Job, Long>, JobRepository{

    Optional<Job> findByJobTitle(String jobTitle);
}
