package pl.sda.springbootdemo.web;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.sda.springbootdemo.domain.user.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(params = "/users")
@Slf4j
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // Przyklad: GET localhost:8080/users/2
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        log.info("logged user: " + userService.getLoggedUser());
        User user = userService.findById(id);
        return UserMapper.INSTANCE.toDTO(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping
    public UserInsertDTO insert(@RequestBody UserInsertDTO userInsertDTO) {
        User userToSave = UserInsertMapper.INSTANCE.toEntity(userInsertDTO);
        return UserInsertMapper.INSTANCE.toDTO(userService.save(userToSave));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDTO> getAll() {
        log.info("logged user " + userService.getLoggedUser());
        List<User> allUsers = userService.getAll();
        return allUsers.stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

}
