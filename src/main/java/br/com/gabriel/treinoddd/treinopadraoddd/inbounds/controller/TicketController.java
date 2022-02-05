package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.controller;

import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.IRoomFacade;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    private final IRoomFacade ticketFacade;

    @Autowired
    public TicketController(IRoomFacade ticketFacade) {
        this.ticketFacade = ticketFacade;
    }

    @GetMapping
    public ResponseEntity<List<DomainEntityDTO>> findAllTickets() {
        return ResponseEntity.ok().body(ticketFacade.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DomainEntityDTO> findTicketById(@PathVariable Long id) {
        return ResponseEntity.ok().body(ticketFacade.findById(id));
    }

    @PostMapping
    public ResponseEntity<DomainEntityDTO> addNewTicket(@RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketFacade.save(ticketDTO));
    }

    @PutMapping
    public ResponseEntity<DomainEntityDTO> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok().body(ticketFacade.update(id, ticketDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DomainEntityDTO> deleteTicketById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ticketFacade.delete(id));
    }
}
