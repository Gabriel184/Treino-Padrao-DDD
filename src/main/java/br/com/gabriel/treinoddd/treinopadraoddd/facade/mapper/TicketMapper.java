package br.com.gabriel.treinoddd.treinopadraoddd.facade.mapper;

import br.com.gabriel.treinoddd.treinopadraoddd.domain.entities.Ticket;
import br.com.gabriel.treinoddd.treinopadraoddd.facade.dto.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketDTO convertToDto(Ticket ticket);
    TicketMapper convertToUser(TicketDTO ticketDTO);

}
