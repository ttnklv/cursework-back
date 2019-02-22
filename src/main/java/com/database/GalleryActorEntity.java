package com.database;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "gallery_actor", schema = "public", catalog = "postgres")
public class GalleryActorEntity {
    private int id;
    private Integer idActor;
    private byte[] photo;
    private ActorEntity actors;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_actor", nullable = true, insertable = false, updatable = false)
    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
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

        GalleryActorEntity that = (GalleryActorEntity) o;

        if (id != that.id) return false;
        if (idActor != null ? !idActor.equals(that.idActor) : that.idActor != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idActor != null ? idActor.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_actor", referencedColumnName = "id_actor")
    public ActorEntity getActors() {
        return actors;
    }

    public void setActors(ActorEntity actorByIdActor) {
        this.actors = actorByIdActor;
    }
}
