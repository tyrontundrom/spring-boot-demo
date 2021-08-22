package pl.sda.springbootdemo.domain.user;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.springbootdemo.domain.adress.Adress;
import pl.sda.springbootdemo.domain.adress.AdressMapper;

@Mapper(uses = {AdressMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
