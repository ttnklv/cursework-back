package com.database;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "post", schema = "public", catalog = "postgres")
public class PostEntity {
    private Integer id;
    private byte[] img;
    private Date createDate;
    private String body;
    private Integer userUsOwnerId;
    private CustomersEntity customers;
    private Collection<PostTagEntity> postTags;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "img", nullable = true)
    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "body", nullable = false, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "user_us_owner_id", nullable = true, insertable = false, updatable = false)
    public Integer getUserUsOwnerId() {
        return userUsOwnerId;
    }

    public void setUserUsOwnerId(Integer userUsOwnerId) {
        this.userUsOwnerId = userUsOwnerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (id != that.id) return false;
        if (!Arrays.equals(img, that.img)) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (userUsOwnerId != null ? !userUsOwnerId.equals(that.userUsOwnerId) : that.userUsOwnerId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(img);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (userUsOwnerId != null ? userUsOwnerId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_us_owner_id", referencedColumnName = "id")
    public CustomersEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomersEntity customersByUserUsOwnerId) {
        this.customers = customersByUserUsOwnerId;
    }

    @OneToMany(mappedBy = "posts")
    public Collection<PostTagEntity> getPostTags() {
        return postTags;
    }

    public void setPostTags(Collection<PostTagEntity> postTagsById) {
        this.postTags = postTagsById;
    }
}
