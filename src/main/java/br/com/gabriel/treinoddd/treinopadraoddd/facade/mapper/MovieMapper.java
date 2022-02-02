package br.com.gabriel.treinoddd.treinopadraoddd.facade.mapper;

import br.com.gabriel.treinoddd.treinopadraoddd.domain.entities.Movie;
import br.com.gabriel.treinoddd.treinopadraoddd.facade.dto.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO convertToDto (Movie movie);
    Movie convertToMovie(MovieDTO movieDTO);

}
