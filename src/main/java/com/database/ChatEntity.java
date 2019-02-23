package com.database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "chat", schema = "public", catalog = "postgres")
public class ChatEntity {
    private Integer id;
    private Integer filmId;
    private String msg;
    private Integer userUsId;
    private Date createDate;
    private FilmEntity film;
    private CustomersEntity customers;
    private Collection<ChatUserEntity> chats;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "film_id", nullable = true, insertable = false, updatable = false)
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "msg", nullable = false, length = -1)
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Basic
    @Column(name = "user_us_id", nullable = true, insertable = false, updatable = false)
    public Integer getUserUsId() {
        return userUsId;
    }

    public void setUserUsId(Integer userUsId) {
        this.userUsId = userUsId;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatEntity that = (ChatEntity) o;

        if (id != that.id) return false;
        if (filmId != null ? !filmId.equals(that.filmId) : that.filmId != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;
        if (userUsId != null ? !userUsId.equals(that.userUsId) : that.userUsId != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (userUsId != null ? userUsId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity filmByFilmId) {
        this.film = filmByFilmId;
    }

    @ManyToOne
    @JoinColumn(name = "user_us_id", referencedColumnName = "id")
    public CustomersEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomersEntity customersByUserUsId) {
        this.customers = customersByUserUsId;
    }

    @OneToMany(mappedBy = "chats")
    public Collection<ChatUserEntity> getChats() {
        return chats;
    }

    public void setChats(Collection<ChatUserEntity> chatUsersById) {
        this.chats = chatUsersById;
    }
}
