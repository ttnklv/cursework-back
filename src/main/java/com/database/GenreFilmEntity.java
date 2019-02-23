package com.database;

import javax.persistence.*;

@Entity
@Table(name = "genre_film", schema = "public", catalog = "postgres")
@IdClass(GenreFilmEntityPK.class)
public class GenreFilmEntity {
    private int idFilm;
    private int idGenre;
    private FilmEntity films;
    private GenreEntity genres;

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "id_genre", nullable = false)
    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreFilmEntity that = (GenreFilmEntity) o;

        if (idFilm != that.idFilm) return false;
        if (idGenre != that.idGenre) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFilm;
        result = 31 * result + idGenre;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id", nullable = false)
    public FilmEntity getFilms() {
        return films;
    }

    public void setFilms(FilmEntity filmByIdFilm) {
        this.films = filmByIdFilm;
    }

    @ManyToOne
    @JoinColumn(name = "id_genre", referencedColumnName = "id", nullable = false)
    public GenreEntity getGenres() {
        return genres;
    }

    public void setGenres(GenreEntity genreByIdGenre) {
        this.genres = genreByIdGenre;
    }
}
