package pl.sda.springbootdemo.domain.adress;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springbootdemo.domain.common.BaseEntity;
import pl.sda.springbootdemo.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "myadresses")
@Getter
@Setter
public class Adress extends BaseEntity {


    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postalCode;

    @ManyToMany(mappedBy = "adresses")
    private List<User> users;

    public Adress() {
    }

    public Adress(String city, String street, String postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }
}
