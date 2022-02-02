package br.com.gabriel.treinoddd.treinopadraoddd.repositories;

import br.com.gabriel.treinoddd.treinopadraoddd.domain.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
