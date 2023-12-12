package chaezzic.chaezzicspring.controller;

import chaezzic.chaezzicspring.domain.User;
import chaezzic.chaezzicspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/userList")
    public ResponseEntity<List<User>> list() {
        List<User> users = userService.findMembers();

        return ResponseEntity.ok(users);
    }
}
