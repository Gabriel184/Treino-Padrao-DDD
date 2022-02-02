package br.com.gabriel.treinoddd.treinopadraoddd.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "MOVIE")
public class Movie extends DomainEntity{

    @Column(name = "mov_name")
    private String name;

    @Column(name = "mov_duration")
    private Integer duration;

    public Movie(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) && Objects.equals(duration, movie.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, duration);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
