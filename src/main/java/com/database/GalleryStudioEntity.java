package com.database;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "gallery_studio", schema = "public", catalog = "postgres")
public class GalleryStudioEntity {
    private int id;
    private Integer idStudio;
    private byte[] photo;
    private StudioEntity studios;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_studio", nullable = true, insertable = false, updatable = false)
    public Integer getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(Integer idStudio) {
        this.idStudio = idStudio;
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

        GalleryStudioEntity that = (GalleryStudioEntity) o;

        if (id != that.id) return false;
        if (idStudio != null ? !idStudio.equals(that.idStudio) : that.idStudio != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idStudio != null ? idStudio.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_studio", referencedColumnName = "id_studio")
    public StudioEntity getStudios() {
        return studios;
    }

    public void setStudios(StudioEntity studioByIdStudio) {
        this.studios = studioByIdStudio;
    }
}
