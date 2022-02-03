package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO extends DomainEntityDTO{
    private String name;
    private Integer number;
    private Integer viwersLimit;

}
