package br.com.gabriel.treinoddd.treinopadraoddd.core.services;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Movie;
import br.com.gabriel.treinoddd.treinopadraoddd.core.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public DomainEntity save(DomainEntity entity) {
        return movieRepository.save((Movie) entity);
    }

    @Override
    public DomainEntity update(Long id, DomainEntity entity) {
        Movie movie = (Movie) entity;
        movie.setId(findById(id).getId());
        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public DomainEntity findById(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tratar corretamente") //TODO - Tratar essa exceção corretamente.
        );
    }

    @Override
    public List<DomainEntity> findAll() {
        return new ArrayList<DomainEntity>(movieRepository.findAll());
    }

    @Override
    public DomainEntity delete(Long id) {
        try {
            movieRepository.deleteById(id);
        }
        catch (RuntimeException e){ //TODO colocar um tratamento descecnte aqui também
            e.printStackTrace();
        }
        return null;
    }
}
