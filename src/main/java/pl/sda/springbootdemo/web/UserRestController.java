package pl.sda.springbootdemo.web;

import org.springframework.web.bind.annotation.*;
import pl.sda.springbootdemo.domain.user.*;

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

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping
    public UserInsertDTO insert(@RequestBody UserInsertDTO userInsertDTO) {
        User userToSave = UserInsertMapper.INSTANCE.toEntity(userInsertDTO);
        return UserInsertMapper.INSTANCE.toDTO(userService.save(userToSave));
    }

}
