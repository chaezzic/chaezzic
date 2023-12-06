package chaezzic.chaezzicspring.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "job_skills")
@NoArgsConstructor
@AllArgsConstructor
public class JobSkills implements Serializable {

    @Id
    @Column(name = "jobskills_id")
    private long id;

    @Column(name = "job_id")
    private long jobId;

    @Column(name = "skill_id")
    private long skillId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }
}
