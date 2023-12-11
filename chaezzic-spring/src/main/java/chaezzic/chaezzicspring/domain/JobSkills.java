package chaezzic.chaezzicspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
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
}
