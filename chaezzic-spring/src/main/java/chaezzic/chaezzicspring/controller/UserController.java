package chaezzic.chaezzicspring.controller;

import chaezzic.chaezzicspring.domain.User;
import chaezzic.chaezzicspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/List")
    public String list(Model model) {
        List<User> users = userService.findMembers();
        model.addAttribute("users", users);

        return "users/userList";
    }
}
