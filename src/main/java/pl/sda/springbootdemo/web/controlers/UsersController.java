package pl.sda.springbootdemo.web.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.springbootdemo.domain.user.User;
import pl.sda.springbootdemo.domain.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/mvc/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        List<User> allUsers = userService.getAll();
        model.addAttribute("users", allUsers);
        return "usersList";
    }
}
