package pl.sda.springbootdemo.domain.adress;

import org.springframework.stereotype.Service;

@Service
public class AdressService {

    private final AdressRepository adressRepository;

    public AdressService(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    public Adress save(Adress adress) {
        return adressRepository.save(adress);
    }
}
