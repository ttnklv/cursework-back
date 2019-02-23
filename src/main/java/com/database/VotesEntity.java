package com.database;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "votes", schema = "public", catalog = "postgres")
public class VotesEntity {
    private int id;
    private Integer countPositive;
    private Integer countNegative;
    private String name;
    private Integer idFilm;
    private Boolean flagAccess;
    private byte[] votesImageUrl;
    private FilmEntity films;
    private Collection<VotesTagEntity> votes;
    private Collection<VotesUserEntity> votesUsers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "count_positive", nullable = true)
    public Integer getCountPositive() {
        return countPositive;
    }

    public void setCountPositive(Integer countPositive) {
        this.countPositive = countPositive;
    }

    @Basic
    @Column(name = "count_negative", nullable = true)
    public Integer getCountNegative() {
        return countNegative;
    }

    public void setCountNegative(Integer countNegative) {
        this.countNegative = countNegative;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "flag_access", nullable = true)
    public Boolean getFlagAccess() {
        return flagAccess;
    }

    public void setFlagAccess(Boolean flagAccess) {
        this.flagAccess = flagAccess;
    }

    @Basic
    @Column(name = "votes_image_url", nullable = true)
    public byte[] getVotesImageUrl() {
        return votesImageUrl;
    }

    public void setVotesImageUrl(byte[] votesImageUrl) {
        this.votesImageUrl = votesImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotesEntity that = (VotesEntity) o;

        if (id != that.id) return false;
        if (countPositive != null ? !countPositive.equals(that.countPositive) : that.countPositive != null)
            return false;
        if (countNegative != null ? !countNegative.equals(that.countNegative) : that.countNegative != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (idFilm != null ? !idFilm.equals(that.idFilm) : that.idFilm != null) return false;
        if (flagAccess != null ? !flagAccess.equals(that.flagAccess) : that.flagAccess != null) return false;
        if (!Arrays.equals(votesImageUrl, that.votesImageUrl)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (countPositive != null ? countPositive.hashCode() : 0);
        result = 31 * result + (countNegative != null ? countNegative.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idFilm != null ? idFilm.hashCode() : 0);
        result = 31 * result + (flagAccess != null ? flagAccess.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(votesImageUrl);
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

    @OneToMany(mappedBy = "votes")
    public Collection<VotesTagEntity> getVotes() {
        return votes;
    }

    public void setVotes(Collection<VotesTagEntity> votesTagsById) {
        this.votes = votesTagsById;
    }

    @OneToMany(mappedBy = "votes")
    public Collection<VotesUserEntity> getVotesUsers() {
        return votesUsers;
    }

    public void setVotesUsers(Collection<VotesUserEntity> votesUsersById) {
        this.votesUsers = votesUsersById;
    }
}
