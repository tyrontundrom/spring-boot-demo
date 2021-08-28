package pl.sda.springbootdemo.domain.role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.sda.springbootdemo.domain.common.BaseEntity;
import pl.sda.springbootdemo.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    private String descripton;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "descripton='" + descripton + '\'' +
                ", users=" + users +
                '}';
    }
}
