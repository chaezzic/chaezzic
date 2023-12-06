package chaezzic.chaezzicspring.domain;

public class JobDTO {
    private String jobTitle;
    private String skillName;
    private Long skillCount;

    public JobDTO(String jobTitle, String skillName, Long skillCount){
        this.jobTitle = jobTitle;
        this.skillName = skillName;
        this.skillCount = skillCount;
    }
}
