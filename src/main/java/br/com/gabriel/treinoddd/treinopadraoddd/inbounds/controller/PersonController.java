package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.controller;

import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.IPersonFacade;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    IPersonFacade personFacade;

    @GetMapping
    public ResponseEntity<List<DomainEntityDTO>> findAllPeople(){
        return ResponseEntity.ok().body(personFacade.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> findPersonById(@PathVariable Long id){
        return ResponseEntity.ok().body((PersonDTO) personFacade.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonDTO> addNewPerson(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok().body((PersonDTO) personFacade.save(personDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO){
        return ResponseEntity.ok().body((PersonDTO) personFacade.update(id, personDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> deletePerson(@PathVariable Long id){
        personFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
