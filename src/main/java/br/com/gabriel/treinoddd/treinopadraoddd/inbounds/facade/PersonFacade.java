package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Person;
import br.com.gabriel.treinoddd.treinopadraoddd.core.services.PersonService;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.PersonDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonFacade implements IPersonFacade {

    private PersonService personServices;
    private PersonMapper personMapper;

    @Autowired
    public PersonFacade(PersonService personService, PersonMapper personMapper) {
        this.personServices = personService;
        this.personMapper = personMapper;
    }

    @Override
    public DomainEntityDTO save(DomainEntityDTO entityDTO) {
        Person person = personMapper.convertToPerson((PersonDTO) entityDTO);
        return personMapper.convertToDto((Person) personServices.save(person));
    }

    @Override
    public DomainEntityDTO update(Long id, DomainEntityDTO entityDTO) {
        Person person = personMapper.convertToPerson((PersonDTO) entityDTO);
        return personMapper.convertToDto((Person) personServices.update(id, person));
    }

    @Override
    public DomainEntityDTO findById(Long id) {
        return personMapper.convertToDto((Person) personServices.findById(id));
    }

    @Override
    public List<DomainEntityDTO> findAll() {
        List<DomainEntity> listOfPeople = new ArrayList<>(personServices.findAll());
        List<DomainEntityDTO> listOfPeopleDTO = new ArrayList<>();
        listOfPeople.forEach(e -> listOfPeopleDTO.add(personMapper.convertToDto((Person) e)));
        return listOfPeopleDTO;
    }

    @Override
    public DomainEntityDTO delete(Long id) {
        return personMapper.convertToDto((Person) personServices.delete(id));
    }
}
