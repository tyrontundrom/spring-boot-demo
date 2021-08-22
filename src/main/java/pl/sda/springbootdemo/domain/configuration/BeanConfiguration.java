package pl.sda.springbootdemo.domain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.sda.springbootdemo.domain.adress.AdressRepository;
import pl.sda.springbootdemo.domain.role.RoleRepository;
import pl.sda.springbootdemo.domain.user.UserRepository;
import pl.sda.springbootdemo.domain.user.UserService;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService getUserService(UserRepository userRepository, AdressRepository adressRepository, BCryptPasswordEncoder encoder, RoleRepository roleRepository) {
        return new UserService(userRepository, adressRepository, encoder, roleRepository);
    }
}
