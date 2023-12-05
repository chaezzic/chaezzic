package chaezzic.chaezzicspring.service;

import chaezzic.chaezzicspring.domain.Job;
import chaezzic.chaezzicspring.repository.JobRepository;
import chaezzic.chaezzicspring.repository.SpringDataJpaJobRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class JobService {

    private final JobRepository jobRepository;
    //private final SpringDataJpaJobRepository springDataJpaJobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }
//
//    public Optional<Job> findJobs(String jobTitle) {
//        return springDataJpaJobRepository.findByJobTitle(jobTitle);
//    }

}
