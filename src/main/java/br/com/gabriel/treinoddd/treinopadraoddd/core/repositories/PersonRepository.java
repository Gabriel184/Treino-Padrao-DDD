package br.com.gabriel.treinoddd.treinopadraoddd.core.repositories;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
