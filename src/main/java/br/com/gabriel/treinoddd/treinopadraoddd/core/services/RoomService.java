package br.com.gabriel.treinoddd.treinopadraoddd.core.services;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Room;
import br.com.gabriel.treinoddd.treinopadraoddd.core.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService implements IRoomService{

    RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public DomainEntity save(DomainEntity entity) {
        Room room = (Room) entity;
        return roomRepository.save(room);
    }

    @Override
    public DomainEntity update(Long id, DomainEntity entity) {
        Room room = (Room) entity;
        room.setId(findById(id).getId());
        return roomRepository.saveAndFlush(room);
    }

    @Override
    public DomainEntity findById(Long id) {
        return roomRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tratar essa Exceção corretamente.")
        );
    }

    @Override
    public List<DomainEntity> findAll() {
        return new ArrayList<>(roomRepository.findAll());
    }

    @Override
    public DomainEntity delete(Long id) {
        try{
            roomRepository.deleteById(id);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }
}
