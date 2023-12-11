package chaezzic.chaezzicspring.controller;

import chaezzic.chaezzicspring.domain.Job;
import chaezzic.chaezzicspring.domain.JobDTO;
import chaezzic.chaezzicspring.domain.response.JobTrendResponse;
import chaezzic.chaezzicspring.domain.selection.JobList;
import chaezzic.chaezzicspring.domain.selection.SelectDTO;
import chaezzic.chaezzicspring.repository.JobRepository;
import chaezzic.chaezzicspring.service.JobService;
import chaezzic.chaezzicspring.service.JobSkillsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;
//    private final JobSkillsService jobSkillsService;
    private final JobRepository jobRepository;

//    @ModelAttribute("yearCodes")
//    public List<Year> yearCodes(){
//        List<Year> yearCodes = new ArrayList<>();
//
//        yearCodes.add(jobSkillsService.getYear2023());
//        yearCodes.add(jobSkillsService.getYear2022());
//
//        return yearCodes;
//    }
//
//    @ModelAttribute("partCodes")
//    public List<Part> partCodes(){
//        List<Part> partCodes = new ArrayList<>();
//
//        partCodes.add(jobSkillsService.getFirstHalf());
//        partCodes.add(jobSkillsService.getSecondHalf());
//
//        return partCodes;
//    }

//    @ModelAttribute("jobCodes")
//    public List<JobList> jobCodes(){
//        List<JobList> jobCodes = new ArrayList<>();
//
//        jobCodes.add(jobSkillsService.getAndroid());
//        jobCodes.add(jobSkillsService.getBackend());
//        jobCodes.add(jobSkillsService.getBlockchain());
//        jobCodes.add(jobSkillsService.getBigData());
//        jobCodes.add(jobSkillsService.getCLang());
//        jobCodes.add(jobSkillsService.getCrossPlatform());
//        jobCodes.add(jobSkillsService.getDataAns());
//        jobCodes.add(jobSkillsService.getDataEng());
//        jobCodes.add(jobSkillsService.getDba());
//        jobCodes.add(jobSkillsService.getDevOps());
//        jobCodes.add(jobSkillsService.getEmbedded());
//        jobCodes.add(jobSkillsService.getEtc());
//        jobCodes.add(jobSkillsService.getFrontend());
//        jobCodes.add(jobSkillsService.getGame());
//        jobCodes.add(jobSkillsService.getHwDev());
//        jobCodes.add(jobSkillsService.getHwEng());
//        jobCodes.add(jobSkillsService.getIos());
//        jobCodes.add(jobSkillsService.getJava());
//        jobCodes.add(jobSkillsService.getMlDev());
//        jobCodes.add(jobSkillsService.getNodeJs());
//        jobCodes.add(jobSkillsService.getPhp());
//        jobCodes.add(jobSkillsService.getPython());
//        jobCodes.add(jobSkillsService.getQa());
//        jobCodes.add(jobSkillsService.getSecEng());
//        jobCodes.add(jobSkillsService.getServer());
//        jobCodes.add(jobSkillsService.getSoftware());
//
//        return jobCodes;
//    }

    @GetMapping("/list")
    public ResponseEntity<List<Job>> list() {
        List<Job> jobs = jobService.findAllJobs();

        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/select")
    public String selectForm(Model model){
        model.addAttribute("select", new SelectDTO());
        return "jobs/jobSelect";
    }

    @PostMapping("/select")
    public SelectDTO selectJob(@ModelAttribute SelectDTO selectDTO, RedirectAttributes redirectAttributes){

        log.info("selectDTO.year={}", selectDTO.getYear());
        log.info("selectDTO.part={}", selectDTO.getPart());
        log.info("selectDTO.job={}", selectDTO.getJob());

        redirectAttributes.addAttribute("year", selectDTO.getYear());
        redirectAttributes.addAttribute("part", selectDTO.getPart());
        redirectAttributes.addAttribute("job", selectDTO.getJob());

        return selectDTO;
    }

    @GetMapping("/showJobTrend/{year}/{part}/{job}")
    public ResponseEntity<?> trend(@PathVariable String year, @PathVariable String part, @PathVariable String job){
        if (job.equals("C, Cpp 개발")){
            job = "C/Cpp 개발";
        } else if (job.equals("네트워크, 클라우드, 보안, 운영")) {
            job = "네트워크/클라우드/보안/운영";
        }

        List<JobDTO> jobDTOList = jobRepository.findTop5Skills(job, part, year);
        Long total = jobRepository.totalCount(job, part, year);

        log.info("Job title: " + jobDTOList.get(0).getJobTitle());
        log.info("Skill name: " + jobDTOList.get(0).getSkillName());
        log.info("Total count: " + total);

//        model.addAttribute("top5JobList", jobDTOList);
//        model.addAttribute("totalCount", total);

        JobTrendResponse response = new JobTrendResponse(jobDTOList, total);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/test")
    public Job test(){
        Job job = new Job();
        job.setId(1234L);
        job.setJobTitle("test.");
        job.setPart("teststet");
        job.setCompany("spring");
        job.setYear("2023");

        return job;
    }
}

