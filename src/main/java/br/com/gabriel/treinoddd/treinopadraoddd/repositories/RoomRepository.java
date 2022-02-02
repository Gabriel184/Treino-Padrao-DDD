package br.com.gabriel.treinoddd.treinopadraoddd.repositories;

import br.com.gabriel.treinoddd.treinopadraoddd.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
