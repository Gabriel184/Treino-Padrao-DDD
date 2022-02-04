package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Movie;
import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.Person;
import br.com.gabriel.treinoddd.treinopadraoddd.core.services.MovieService;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.MovieDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieFacade implements IMovieFacade{

    private MovieMapper movieMapper;
    private MovieService movieService;

    @Autowired
    public MovieFacade(MovieMapper movieMapper, MovieService movieService) {
        this.movieMapper = movieMapper;
        this.movieService = movieService;
    }

    @Override
    public DomainEntityDTO save(DomainEntityDTO entityDTO) {
        Movie movie = movieMapper.convertToMovie((MovieDTO) entityDTO);
        return movieMapper.convertToDto((Movie) movieService.save(movie));
    }

    @Override
    public DomainEntityDTO update(Long id, DomainEntityDTO entityDTO) {
        Movie movie = movieMapper.convertToMovie((MovieDTO) entityDTO);
        return movieMapper.convertToDto((Movie) movieService.update(id, movie));
    }

    @Override
    public DomainEntityDTO findById(Long id) {
        return movieMapper.convertToDto((Movie) movieService.findById(id));
    }

    @Override
    public List<DomainEntityDTO> findAll() {
        List<DomainEntity> listOfMovies = new ArrayList<>(movieService.findAll());
        List<DomainEntityDTO> listOfMoviesDTO = new ArrayList<>();
        listOfMovies.forEach(e -> listOfMoviesDTO.add(movieMapper.convertToDto((Movie) e)));
        return listOfMoviesDTO;
    }

    @Override
    public DomainEntityDTO delete(Long id) {
        return movieMapper.convertToDto((Movie) movieService.delete(id));
    }
}
