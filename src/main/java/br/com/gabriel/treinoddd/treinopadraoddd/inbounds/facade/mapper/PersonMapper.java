package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Person;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO convertToDto(Person person);
    Person convertToPerson(PersonDTO personDTO);

}
