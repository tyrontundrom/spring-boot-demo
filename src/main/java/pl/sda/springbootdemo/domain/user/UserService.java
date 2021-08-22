package pl.sda.springbootdemo.domain.user;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import pl.sda.springbootdemo.domain.adress.Adress;
import pl.sda.springbootdemo.domain.adress.AdressRepository;
import pl.sda.springbootdemo.domain.role.RoleRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;
    private final AdressRepository adressRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, AdressRepository adressRepository, BCryptPasswordEncoder encoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.adressRepository = adressRepository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public User save(User user) {
        List<Adress> adresses = user.getAdresses();
        if (!CollectionUtils.isEmpty(adresses)) {
            List<Adress> savedAdresses = adressRepository.saveAll(adresses);
            user.setAdresses(savedAdresses);
        }
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        Long roleId = savedUser.getRole().getId();
        savedUser.setRole(roleRepository.getById(roleId));
        return savedUser;
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

    public Authentication getLoggedUser() {
       return SecurityContextHolder.getContext().getAuthentication();
    }

    public List<User> getAll() {
      return userRepository.findAll();
    }
}
