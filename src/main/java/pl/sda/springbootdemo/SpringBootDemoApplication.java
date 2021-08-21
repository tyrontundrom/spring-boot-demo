package pl.sda.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springbootdemo.domain.adress.Adress;
import pl.sda.springbootdemo.domain.adress.AdressService;
import pl.sda.springbootdemo.domain.user.User;
import pl.sda.springbootdemo.domain.user.UserService;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {
    private final UserService userService;
    private final AdressService adressService;

    public SpringBootDemoApplication(UserService userService, AdressService adressService) {
        this.userService = userService;
        this.adressService = adressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Adress adress1 = new Adress("Lodz", "Piotrkowska 12", "90-321");
//        Adress adress2 = new Adress("Lodz", "Mickiewicza 82", "92-301");
//
//        User user = new User("Jan", "Kowalski", "janko","",true);
//        user.getAdresses().addAll(Arrays.asList(adressService.save(adress1),adressService.save(adress2)));
//
//        System.out.println(userService.save(user));
    }
}
