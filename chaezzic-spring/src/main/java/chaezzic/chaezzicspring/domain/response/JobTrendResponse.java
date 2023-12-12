package chaezzic.chaezzicspring.domain.response;

import chaezzic.chaezzicspring.domain.JobDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class JobTrendResponse {
    private List<JobDTO> top5JobList;
    private Long totalCount;

    public JobTrendResponse(List<JobDTO> top5JobList, Long totalCount) {
        this.top5JobList = top5JobList;
        this.totalCount = totalCount;

    }
}
