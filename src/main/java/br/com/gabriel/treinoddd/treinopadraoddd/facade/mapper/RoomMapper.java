package br.com.gabriel.treinoddd.treinopadraoddd.facade.mapper;

import br.com.gabriel.treinoddd.treinopadraoddd.domain.entities.Room;
import br.com.gabriel.treinoddd.treinopadraoddd.facade.dto.RoomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomDTO convertToDto(Room room);
    Room convertToRoom(RoomDTO roomDTO);
}
