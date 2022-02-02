package br.com.gabriel.treinoddd.treinopadraoddd.repositories;

import br.com.gabriel.treinoddd.treinopadraoddd.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
