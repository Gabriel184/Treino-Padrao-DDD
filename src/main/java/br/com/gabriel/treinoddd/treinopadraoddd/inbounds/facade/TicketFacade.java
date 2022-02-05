package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Ticket;
import br.com.gabriel.treinoddd.treinopadraoddd.core.services.TicketService;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.TicketDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketFacade implements ITicketFacade{

    private TicketService ticketService;
    private TicketMapper ticketMapper;

    @Autowired
    public TicketFacade(TicketService ticketService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public DomainEntityDTO save(DomainEntityDTO entityDTO) {
        Ticket ticket = ticketMapper.convertToTicket((TicketDTO) entityDTO);
        return ticketMapper.convertToDto((Ticket) ticketService.save(ticket));
    }

    @Override
    public DomainEntityDTO update(Long id, DomainEntityDTO entityDTO) {
        Ticket ticket = ticketMapper.convertToTicket((TicketDTO) entityDTO);
        return ticketMapper.convertToDto((Ticket) ticketService.update(id, ticket));
    }

    @Override
    public DomainEntityDTO findById(Long id) {
        return ticketMapper.convertToDto((Ticket) ticketService.findById(id));
    }

    @Override
    public List<DomainEntityDTO> findAll() {
        List<DomainEntity> listOfTickets = new ArrayList<>(ticketService.findAll());
        List<DomainEntityDTO> listOfTicketsDTO = new ArrayList<>();
        listOfTickets.forEach(e -> listOfTicketsDTO.add(ticketMapper.convertToDto((Ticket) e)));
        return listOfTicketsDTO;
    }

    @Override
    public DomainEntityDTO delete(Long id) {
        return ticketMapper.convertToDto((Ticket) ticketService.delete(id));
    }
}
