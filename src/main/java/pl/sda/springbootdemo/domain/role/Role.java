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
@ToString(callSuper = true)
public class Role extends BaseEntity {
    @Column(nullable = false)
    private String name;

    private String descripton;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
