package chaezzic.chaezzicspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "`JOB`")
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Job{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "job_id")
    @Column(name = "jobId")
    private long id;

    @Column(name = "company_name")
    private String company;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "apply_date")
    private String part;
}
