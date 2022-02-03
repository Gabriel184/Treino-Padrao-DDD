package br.com.gabriel.treinoddd.treinopadraoddd.core.repositories;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
