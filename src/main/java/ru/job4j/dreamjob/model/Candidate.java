package ru.job4j.dreamjob.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Candidate implements Serializable {
    private int id;
    private String name;

    private byte[] photo;

    private String description;
    private LocalDateTime created;
    private boolean visible;
    private City city;

    public Candidate() {
    }

    public Candidate(int id,
                     String name) {

        this.id = id;
        this.name = name;
    }

    public Candidate(int id,
                     String name,
                     String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Candidate(int id,
                     String name,
                     String description,
                     City city,
                     LocalDateTime created) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Candidate{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", description='" + description
                + '\''
                + ", created=" + created
                + '}';
    }
}
