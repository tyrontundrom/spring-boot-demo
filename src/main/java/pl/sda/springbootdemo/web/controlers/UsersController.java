package pl.sda.springbootdemo.web.controlers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:userslist";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
         model.addAttribute("user",userService.findById(id));
         return "editUser";
    }
}
