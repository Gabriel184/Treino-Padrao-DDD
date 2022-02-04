package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDTO extends DomainEntityDTO {
    private PersonDTO owner;
    private Double value;
    private MovieDTO movie;
    private RoomDTO room;
}
