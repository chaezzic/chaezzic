package chaezzic.chaezzicspring.domain;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

//    @Enumerated(EnumType.STRING)
//    @Column(name="role", nullable = false)
//    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getRole() {
//        return this.role.getRoleName();
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public User update(String name, Role role){
//        return this;
//    }
}
