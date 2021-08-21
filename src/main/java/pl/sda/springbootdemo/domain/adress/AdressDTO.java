package pl.sda.springbootdemo.domain.adress;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdressDTO {


    private Long id;
    private String city;
    private String street;
    private String postalCode;


}
