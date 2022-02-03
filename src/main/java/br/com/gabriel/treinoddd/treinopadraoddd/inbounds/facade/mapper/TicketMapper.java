package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Ticket;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketDTO convertToDto(Ticket ticket);
    TicketMapper convertToUser(TicketDTO ticketDTO);

}
