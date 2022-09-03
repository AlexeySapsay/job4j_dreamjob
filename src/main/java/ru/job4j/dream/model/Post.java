package ru.job4j.dream.model;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

public class Post {
    private int id;
    private String name;
    private String description;
    private Calendar created;

    public Post(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = Calendar.getInstance();
    }

    public Post(int id, String name, String description, Calendar created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = Calendar.getInstance();
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

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        if (id != post.id) {
            return false;
        }
        if (name != null ? !name.equals(post.name) : post.name != null) {
            return false;
        }
        if (description != null ? !description.equals(post.description) : post.description != null) {
            return false;
        }
        return created != null ? created.equals(post.created) : post.created == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
