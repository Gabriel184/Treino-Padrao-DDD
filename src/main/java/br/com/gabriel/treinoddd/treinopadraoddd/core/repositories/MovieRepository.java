package br.com.gabriel.treinoddd.treinopadraoddd.core.repositories;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
