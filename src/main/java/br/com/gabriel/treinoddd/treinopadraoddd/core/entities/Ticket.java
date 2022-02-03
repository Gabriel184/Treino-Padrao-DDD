package br.com.gabriel.treinoddd.treinopadraoddd.core.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TICKETS")
public class Ticket extends DomainEntity{

    @OneToOne
    @JoinColumn(name = "tck_prn_id")
    private Person owner;

    @Column(name = "tck_value")
    private Double value;

    @OneToOne
    @JoinColumn(name = "tck_mov_id")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "tck_rom_id")
    private Room room;

    public Ticket() {}

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(owner, ticket.owner) && Objects.equals(value, ticket.value) && Objects.equals(movie, ticket.movie) && Objects.equals(room, ticket.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), owner, value, movie, room);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", active=" + active +
                ", owner=" + owner +
                ", value=" + value +
                ", movie=" + movie +
                ", room=" + room +
                '}';
    }
}
