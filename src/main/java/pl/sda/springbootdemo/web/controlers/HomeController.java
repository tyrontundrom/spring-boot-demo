package pl.sda.springbootdemo.web.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.springbootdemo.domain.user.UserService;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public String index(Model model) {
        model.addAttribute("user", userService.getLoggedUser().getCredentials());
        return "index";
    }
}
