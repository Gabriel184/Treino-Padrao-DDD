package br.com.gabriel.treinoddd.treinopadraoddd.core.services;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Person;
import br.com.gabriel.treinoddd.treinopadraoddd.core.repositories.PersonRepository;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.PersonDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public DomainEntityDTO save(DomainEntityDTO entity) {
        try {
            Person person = personMapper.convertToPerson((PersonDTO) entity);
            return personMapper.convertToDto(personRepository.save(person));
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DomainEntityDTO update(Long id, DomainEntityDTO entityDTO) {
        Person person = personMapper.convertToPerson((PersonDTO) entityDTO);
        person.setId(personMapper.convertToPerson((PersonDTO) findById(id)).getId());
        return personMapper.convertToDto(personRepository.saveAndFlush(person));
    }

    @Override
    public DomainEntityDTO findById(Long id) {
        return personMapper.convertToDto(
                personRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Tratar essa exceçao corretamente")
                )
        );//TODO - Colocar uma exceçao correta
    }

    @Override
    public List<DomainEntityDTO> findAll() {
        List<? extends DomainEntity> listOfPeople = personRepository.findAll();
        List<DomainEntityDTO> listOfDtoPeople = new ArrayList<>();
        listOfPeople.forEach(e -> listOfDtoPeople.add(personMapper.convertToDto((Person) e)));
        return listOfDtoPeople;
    }

    @Override
    public DomainEntityDTO delete(Long id) {
        try {
            personRepository.deleteById(id);
        }
        catch (RuntimeException e){ //TODO colocar um tratamento descecnte aqui também
            e.printStackTrace();
        }
        return null;
    }
}
