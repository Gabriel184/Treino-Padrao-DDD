package br.com.gabriel.treinoddd.treinopadraoddd.facade.mapper;

import br.com.gabriel.treinoddd.treinopadraoddd.domain.entities.Person;
import br.com.gabriel.treinoddd.treinopadraoddd.facade.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO convertToDto(Person person);
    Person convertToPerson(PersonDTO personDTO);

}
