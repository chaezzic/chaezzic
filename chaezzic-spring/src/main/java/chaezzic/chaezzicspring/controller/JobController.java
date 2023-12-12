package chaezzic.chaezzicspring.controller;

import chaezzic.chaezzicspring.domain.Job;
import chaezzic.chaezzicspring.domain.JobDTO;
import chaezzic.chaezzicspring.domain.response.JobTrendResponse;
import chaezzic.chaezzicspring.repository.JobRepository;
import chaezzic.chaezzicspring.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;
    private final JobRepository jobRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Job>> list() {
        List<Job> jobs = jobService.findAllJobs();

        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/showJobTrend/{year}/{part}/{job}")
    public ResponseEntity<?> trend(@PathVariable String year, @PathVariable String part, @PathVariable String job){

        List<JobDTO> jobDTOList = jobRepository.findTop5Skills(job, part, year);
        Long total = jobRepository.totalCount(job, part, year);

        log.info("Job title: " + jobDTOList.get(0).getJobTitle());
        log.info("Skill name: " + jobDTOList.get(0).getSkillName());
        log.info("Total count: " + total);

        JobTrendResponse response = new JobTrendResponse(jobDTOList, total);

        return ResponseEntity.ok(response);
    }
}

