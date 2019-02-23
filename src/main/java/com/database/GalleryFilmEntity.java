package com.database;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "gallery_film", schema = "public", catalog = "postgres")
public class GalleryFilmEntity {
    private int id;
    private Integer idFilm;
    private byte[] photo;
    private FilmEntity films;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_film", nullable = true, insertable = false, updatable = false)
    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    @Basic
    @Column(name = "photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GalleryFilmEntity that = (GalleryFilmEntity) o;

        if (id != that.id) return false;
        if (idFilm != null ? !idFilm.equals(that.idFilm) : that.idFilm != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idFilm != null ? idFilm.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id")
    public FilmEntity getFilms() {
        return films;
    }

    public void setFilms(FilmEntity filmByIdFilm) {
        this.films = filmByIdFilm;
    }
}
