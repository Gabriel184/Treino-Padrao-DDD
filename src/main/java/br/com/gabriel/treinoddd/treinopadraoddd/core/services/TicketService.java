package br.com.gabriel.treinoddd.treinopadraoddd.core.services;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Ticket;
import br.com.gabriel.treinoddd.treinopadraoddd.core.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService implements ITicketService{

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Override
    public DomainEntity save(DomainEntity entity) {
        Ticket ticket = (Ticket) entity;
        return ticketRepository.save(ticket);
    }

    @Override
    public DomainEntity update(Long id, DomainEntity entity) {
        return null;
    }

    @Override
    public DomainEntity findById(Long id) {
        return ticketRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Trate essa exceção corretamente!") //TODO - Tratar essa exceção corretamente.
        );
    }

    @Override
    public List<DomainEntity> findAll() {
        return new ArrayList<>(ticketRepository.findAll());
    }

    @Override
    public DomainEntity delete(Long id) {
        try{
            ticketRepository.deleteById(id);
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }

}
