package chaezzic.chaezzicspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "job_skills")
@NoArgsConstructor
@AllArgsConstructor
public class JobSkills{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobskills_id")
    private long id;

    @Column(name = "job_id")
    private long jobId;

    @Column(name = "skill_id")
    private long skillId;
}
