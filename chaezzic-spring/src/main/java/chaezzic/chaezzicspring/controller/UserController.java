package chaezzic.chaezzicspring.controller;

import chaezzic.chaezzicspring.domain.Role;
import chaezzic.chaezzicspring.domain.User;
import chaezzic.chaezzicspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/new")
    public String createForm() {
        return "users/createUserForm";
    }

    @PostMapping("/users/new")
    public String create(UserForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setRole(Role.USER);

        userService.join(user);

        System.out.println(user.getName());
        System.out.println(user.getEmail());
        return "redirect:/";
    }

    @GetMapping("/users/List")
    public String list(Model model) {
        List<User> users = userService.findMembers();
        model.addAttribute("users", users);

        return "users/userList";
    }
}
