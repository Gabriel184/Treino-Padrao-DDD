package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Room;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.RoomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomDTO convertToDto(Room room);
    Room convertToRoom(RoomDTO roomDTO);
}
