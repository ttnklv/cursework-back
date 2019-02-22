package com.database;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "genre", schema = "public", catalog = "postgres")
public class GenreEntity {
    private Integer id;
    private String name;
    private Collection<GenreFilmEntity> genreFilms;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "genres")
    public Collection<GenreFilmEntity> getGenreFilms() {
        return genreFilms;
    }

    public void setGenreFilms(Collection<GenreFilmEntity> genreFilmsById) {
        this.genreFilms = genreFilmsById;
    }
}
