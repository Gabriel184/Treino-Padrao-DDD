package br.com.gabriel.treinoddd.treinopadraoddd.core.repositories;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
