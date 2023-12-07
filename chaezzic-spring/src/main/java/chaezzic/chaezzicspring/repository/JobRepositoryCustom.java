package chaezzic.chaezzicspring.repository;


import chaezzic.chaezzicspring.domain.Job;
import chaezzic.chaezzicspring.domain.JobDTO;

import java.util.List;

public interface JobRepositoryCustom {
    List<JobDTO> findTop5Skills(String jobTitle, String part, String year);
}
