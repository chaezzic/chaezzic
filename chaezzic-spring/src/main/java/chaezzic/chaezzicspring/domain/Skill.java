package chaezzic.chaezzicspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "skills")
@NoArgsConstructor
@AllArgsConstructor
public class Skill implements Serializable {

    @Id
    @Column(name = "skill_id")
    private long id;

    @Column(name = "skill_name")
    private String name;

}
