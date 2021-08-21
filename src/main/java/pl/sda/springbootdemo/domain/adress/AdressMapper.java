package pl.sda.springbootdemo.domain.adress;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdressMapper {

    AdressMapper INSTANCE = Mappers.getMapper(AdressMapper.class);

    AdressDTO toDTO(Adress adress);

    Adress toEntity(AdressDTO adressDTO);
}
