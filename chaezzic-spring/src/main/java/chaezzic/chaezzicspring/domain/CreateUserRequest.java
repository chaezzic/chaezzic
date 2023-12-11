package chaezzic.chaezzicspring.domain;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String id;
    private String password;
    private String email;
}
