package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Ticket;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketDTO convertToDto(Ticket ticket);
    Ticket convertToTicket(TicketDTO ticketDTO);

}
