package pl.sda.springbootdemo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String login);

    List<User> getUserByLastName(String lastName);

    @Query("select u from User u join fetch u.adresses")
    User getUserFetchJoinAdresses(String login);
}
