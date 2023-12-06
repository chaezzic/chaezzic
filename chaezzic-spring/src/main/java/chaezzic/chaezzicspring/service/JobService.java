package chaezzic.chaezzicspring.service;

import chaezzic.chaezzicspring.domain.Job;
import chaezzic.chaezzicspring.repository.JobRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Long join(Job job){
        jobRepository.save(job);

        return job.getId();
    }

}
