package pl.sda.springbootdemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springbootdemo.domain.user.User;
import pl.sda.springbootdemo.domain.user.UserDTO;
import pl.sda.springbootdemo.domain.user.UserMapper;
import pl.sda.springbootdemo.domain.user.UserService;

@RestController
@RequestMapping(params = "/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // Przyklad: GET localhost:8080/users/2
    @GetMapping(path = "/{id}")
    UserDTO findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return UserMapper.INSTANCE.toDTO(user);
    }

}
