package com.database;

import javax.persistence.*;

@Entity
@Table(name = "cast_actor", schema = "public", catalog = "postgres")
@IdClass(CastActorEntityPK.class)
public class CastActorEntity {
    private int idFilm;
    private int idActor;
    private FilmEntity film;
    private ActorEntity actor;

    @Id
    @Column(name = "id_film", nullable = false)
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "id_actor", nullable = false)
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CastActorEntity that = (CastActorEntity) o;

        if (idFilm != that.idFilm) return false;
        if (idActor != that.idActor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFilm;
        result = 31 * result + idActor;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id", nullable = false)
    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity filmByIdFilm) {
        this.film = filmByIdFilm;
    }

    @ManyToOne
    @JoinColumn(name = "id_actor", referencedColumnName = "id_actor", nullable = false)
    public ActorEntity getActor() {
        return actor;
    }

    public void setActor(ActorEntity actorByIdActor) {
        this.actor = actorByIdActor;
    }
}
