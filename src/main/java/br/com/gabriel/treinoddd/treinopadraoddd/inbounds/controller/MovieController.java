package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.controller;

import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.IMovieFacade;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.MovieDTO;
import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    IMovieFacade movieFacade;

    @GetMapping
    public ResponseEntity<List<DomainEntityDTO>> findAllMovies(){
        return ResponseEntity.ok().body(movieFacade.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findMovieById(@PathVariable Long id){
        return ResponseEntity.ok().body((MovieDTO) movieFacade.findById(id));
    }

    @PostMapping
    public ResponseEntity<MovieDTO> addNewMovie(@RequestBody MovieDTO personDTO) {
        return ResponseEntity.ok().body((MovieDTO) movieFacade.save(personDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok().body((MovieDTO) movieFacade.update(id, movieDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> deleteMovie(@PathVariable Long id){
        movieFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

}
