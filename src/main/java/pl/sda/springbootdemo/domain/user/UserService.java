package pl.sda.springbootdemo.domain.user;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import pl.sda.springbootdemo.domain.adress.Adress;
import pl.sda.springbootdemo.domain.adress.AdressRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;
    private final AdressRepository adressRepository;

    public UserService(UserRepository userRepository, AdressRepository adressRepository) {
        this.userRepository = userRepository;
        this.adressRepository = adressRepository;
    }

    @Transactional
    public User save(User user) {
        List<Adress> adresses = user.getAdresses();
        if (CollectionUtils.isEmpty(adresses)) {
            List<Adress> savedAdresses = adressRepository.saveAll(adresses);
            user.setAdresses(savedAdresses);
        }
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User getByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public List<User> getByLastName(String lastName) {
        return userRepository.getUserByLastName(lastName);
    }

    public User findByLoginWithAdresses(String login) {
        return userRepository.getUserFetchJoinAdresses(login);
    }

    public User findById(Long id) {
        return userRepository.getById(id);
    }
}
