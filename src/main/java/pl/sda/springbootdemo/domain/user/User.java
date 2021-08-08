package pl.sda.springbootdemo.domain.user;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springbootdemo.domain.adress.Adress;
import pl.sda.springbootdemo.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "myusers")
@Getter @Setter
public class User extends BaseEntity {




    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String login;

    private String password;

    @ManyToMany
    @JoinTable(name = "usersadreses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "adress_id")})
    private List<Adress> adresses;

}
