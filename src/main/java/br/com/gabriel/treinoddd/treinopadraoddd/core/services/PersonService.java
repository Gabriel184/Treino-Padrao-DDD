package br.com.gabriel.treinoddd.treinopadraoddd.core.services;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Person;
import br.com.gabriel.treinoddd.treinopadraoddd.core.repositories.PersonRepository;
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
    public DomainEntity save(DomainEntity entity) {
        try {
            Person person = (Person) entity;
            return personRepository.save(person);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DomainEntity update(Long id, DomainEntity entity) {
        Person person = (Person) entity;
        person.setId(findById(id).getId());
        return personRepository.saveAndFlush(person);
    }

    @Override
    public DomainEntity findById(Long id) {
        return personRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tratar essa exceçao corretamente")
        );//TODO - Colocar uma exceçao correta
    }

    @Override
    public List<DomainEntity> findAll() {
        return new ArrayList<>(personRepository.findAll());
    }

    @Override
    public DomainEntity delete(Long id) {
        try {
            personRepository.deleteById(id);
        }
        catch (RuntimeException e){ //TODO colocar um tratamento descecnte aqui também
            e.printStackTrace();
        }
        return null;
    }
}
