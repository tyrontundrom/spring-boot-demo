package pl.sda.springbootdemo.domain.user;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springbootdemo.domain.role.RoleDTO;

@Getter
@Setter
public class UserInsertDTO extends UserDTO {
    private String password;
    private String name;
    private RoleDTO role;
}
