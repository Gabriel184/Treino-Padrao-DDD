package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.controller;

import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.IRoomFacade;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    IRoomFacade roomFacade;

    @GetMapping
    public ResponseEntity<List<DomainEntityDTO>> findAllPeople(){
        return ResponseEntity.ok().body(roomFacade.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoomDTO> findPersonById(@PathVariable Long id){
        return ResponseEntity.ok().body((RoomDTO) roomFacade.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoomDTO> addNewPerson(@RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok().body((RoomDTO) roomFacade.save(roomDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RoomDTO> updatePerson(@PathVariable Long id, @RequestBody RoomDTO roomDto){
        return ResponseEntity.ok().body((RoomDTO) roomFacade.update(id, roomDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<RoomDTO> deletePerson(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body((RoomDTO) roomFacade.delete(id));
    }

}
