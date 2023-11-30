package chaezzic.chaezzicspring.controller;

import chaezzic.chaezzicspring.domain.Job;
import chaezzic.chaezzicspring.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs/List")
    public String list(Model model) {
//        Optional<Job> jobs = jobService.findJobs("안드로이드 개발");
        List<Job> jobs = jobService.findAllJobs();
        model.addAttribute("jobs", jobs);

        return "jobs/jobList";
    }
}
