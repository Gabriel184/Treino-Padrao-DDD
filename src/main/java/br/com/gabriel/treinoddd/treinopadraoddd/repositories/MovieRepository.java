package br.com.gabriel.treinoddd.treinopadraoddd.repositories;

import br.com.gabriel.treinoddd.treinopadraoddd.domain.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
