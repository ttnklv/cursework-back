package com.database;

import javax.persistence.*;

@Entity
@Table(name = "film_tag", schema = "public", catalog = "postgres")
@IdClass(FilmTagEntityPK.class)
public class FilmTagEntity {
    private int idTag;
    private int idFilm;
    private TagEntity tags;
    private FilmEntity films;

    @Id
    @Column(name = "id_tag", nullable = false)
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmTagEntity that = (FilmTagEntity) o;

        if (idTag != that.idTag) return false;
        if (idFilm != that.idFilm) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTag;
        result = 31 * result + idFilm;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_tag", referencedColumnName = "id", nullable = false)
    public TagEntity getTags() {
        return tags;
    }

    public void setTags(TagEntity tagByIdTag) {
        this.tags = tagByIdTag;
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id", nullable = false)
    public FilmEntity getFilms() {
        return films;
    }

    public void setFilms(FilmEntity filmByIdFilm) {
        this.films = filmByIdFilm;
    }
}
