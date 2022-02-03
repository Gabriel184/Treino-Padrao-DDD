package br.com.gabriel.treinoddd.treinopadraoddd.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ROOM")
public class Room extends DomainEntity{

    @Column(name = "rom_name")
    private String name;

    @Column(name = "rom_number")
    private Integer number;

    @Column(name = "rom_viwers_limit")
    private Integer viwersLimit;

    public Room(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getViwersLimit() {
        return viwersLimit;
    }

    public void setViwersLimit(Integer viwersLimit) {
        this.viwersLimit = viwersLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) && Objects.equals(number, room.number) && Objects.equals(viwersLimit, room.viwersLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, number, viwersLimit);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", viwersLimit=" + viwersLimit +
                '}';
    }
}
