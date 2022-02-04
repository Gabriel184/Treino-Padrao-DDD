package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Room;
import br.com.gabriel.treinoddd.treinopadraoddd.core.services.RoomService;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.RoomDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomFacade implements IRoomFacade{

    private RoomMapper roomMapper;
    private RoomService roomService;

    @Autowired
    public RoomFacade(RoomMapper roomMapper, RoomService roomService) {
        this.roomMapper = roomMapper;
        this.roomService = roomService;
    }


    @Override
    public DomainEntityDTO save(DomainEntityDTO entityDTO) {
        Room room = roomMapper.convertToRoom((RoomDTO) entityDTO);
        return roomMapper.convertToDto((Room) roomService.save(room));
    }

    @Override
    public DomainEntityDTO update(Long id, DomainEntityDTO entityDTO) {
        Room room = roomMapper.convertToRoom((RoomDTO) entityDTO);
        return roomMapper.convertToDto((Room) roomService.update(id, room));
    }

    @Override
    public DomainEntityDTO findById(Long id) {
        return roomMapper.convertToDto((Room) roomService.findById(id));
    }

    @Override
    public List<DomainEntityDTO> findAll() {
        List<DomainEntity> listOfRooms = new ArrayList<>(roomService.findAll());
        List<DomainEntityDTO> listOfRoomsDTO = new ArrayList<>();
        listOfRooms.forEach(e -> listOfRoomsDTO.add(roomMapper.convertToDto((Room) e)));
        return listOfRoomsDTO;
    }

    @Override
    public DomainEntityDTO delete(Long id) {
        return roomMapper.convertToDto((Room) roomService.delete(id));
    }
}
