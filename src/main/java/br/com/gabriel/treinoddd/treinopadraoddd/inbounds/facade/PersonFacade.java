package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade;

import br.com.gabriel.treinoddd.treinopadraoddd.core.services.PersonService;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonFacade implements IPersonFacade{

    private PersonService personServices;

    @Autowired
    public PersonFacade(PersonService personService){
        this.personServices = personService;
    }

    @Override
    public DomainEntityDTO save(DomainEntityDTO entityDTO) {
        return personServices.save(entityDTO);
    }

    @Override
    public DomainEntityDTO update(Long id, DomainEntityDTO entityDTO) {
        return personServices.update(id, entityDTO);
    }

    @Override
    public DomainEntityDTO findById(Long id) {
        return personServices.findById(id);
    }

    @Override
    public List<DomainEntityDTO> findAll() {
        return personServices.findAll();
    }

    @Override
    public DomainEntityDTO delete(Long id) {
        return personServices.delete(id);
    }
}
