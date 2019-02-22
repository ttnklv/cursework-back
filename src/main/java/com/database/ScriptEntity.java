package com.database;

import javax.persistence.*;

@Entity
@Table(name = "script", schema = "public", catalog = "postgres")
@IdClass(ScriptEntityPK.class)
public class ScriptEntity {
    private int idFilm;
    private int idStudio;
    private FilmEntity films;
    private StudioEntity studios;

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "id_studio", nullable = false)
    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScriptEntity that = (ScriptEntity) o;

        if (idFilm != that.idFilm) return false;
        if (idStudio != that.idStudio) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFilm;
        result = 31 * result + idStudio;
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
    @JoinColumn(name = "id_studio", referencedColumnName = "id_studio", nullable = false)
    public StudioEntity getStudios() {
        return studios;
    }

    public void setStudios(StudioEntity studioByIdStudio) {
        this.studios = studioByIdStudio;
    }
}
