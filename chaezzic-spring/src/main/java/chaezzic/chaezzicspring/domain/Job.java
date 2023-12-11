package chaezzic.chaezzicspring.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "`JOB`")
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Job implements Serializable {

    @Id
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
    private String date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
