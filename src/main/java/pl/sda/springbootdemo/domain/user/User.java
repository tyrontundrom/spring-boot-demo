package pl.sda.springbootdemo.domain.user;

import lombok.*;
import pl.sda.springbootdemo.domain.adress.Adress;
import pl.sda.springbootdemo.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "myusers")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class User extends BaseEntity {


    public User(String firstName, String lastName, String login, String password, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.active = active;
    }

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String login;

    private String password;

    @Column(name = "is_active")
    private boolean active;

    @ManyToMany
    @JoinTable(name = "usersadreses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "adress_id")})
    private List<Adress> adresses;

}
