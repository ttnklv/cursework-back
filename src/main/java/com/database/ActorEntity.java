package com.database;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "actor", schema = "public", catalog = "postgres")
public class ActorEntity {
    private Integer idActor;
    private String aboutMe;
    private CustomersEntity customerActor;
    private Collection<CastActorEntity> castActors;
    private Collection<FollowerActorEntity> followerActors;
    private Collection<GalleryActorEntity> galleryActors;
    private Collection<ScoreActorEntity> scoreActors;

    @Id
    @Column(name = "id_actor", nullable = false)
    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    @Basic
    @Column(name = "about_me", nullable = true, length = -1)
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorEntity that = (ActorEntity) o;

        if (idActor != that.idActor) return false;
        if (aboutMe != null ? !aboutMe.equals(that.aboutMe) : that.aboutMe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idActor;
        result = 31 * result + (aboutMe != null ? aboutMe.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "id_actor", referencedColumnName = "id", nullable = false)
    public CustomersEntity getCustomerActor() {
        return customerActor;
    }

    public void setCustomerActor(CustomersEntity customersByIdActor) {
        this.customerActor = customersByIdActor;
    }

    @OneToMany(mappedBy = "actor")
    public Collection<CastActorEntity> getCastActors() {
        return castActors;
    }

    public void setCastActors(Collection<CastActorEntity> castActorsByIdActor) {
        this.castActors = castActorsByIdActor;
    }

    @OneToMany(mappedBy = "actors")
    public Collection<FollowerActorEntity> getFollowerActors() {
        return followerActors;
    }

    public void setFollowerActors(Collection<FollowerActorEntity> followerActorsByIdActor) {
        this.followerActors = followerActorsByIdActor;
    }

    @OneToMany(mappedBy = "actors")
    public Collection<GalleryActorEntity> getGalleryActors() {
        return galleryActors;
    }

    public void setGalleryActors(Collection<GalleryActorEntity> galleryActorsByIdActor) {
        this.galleryActors = galleryActorsByIdActor;
    }

    @OneToMany(mappedBy = "actors")
    public Collection<ScoreActorEntity> getScoreActors() {
        return scoreActors;
    }

    public void setScoreActors(Collection<ScoreActorEntity> scoreActorsByIdActor) {
        this.scoreActors = scoreActorsByIdActor;
    }
}
