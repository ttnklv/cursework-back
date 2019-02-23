package com.database;

import javax.persistence.*;

@Entity
@Table(name = "follower_studio", schema = "public", catalog = "postgres")
@IdClass(FollowerStudioEntityPK.class)
public class FollowerStudioEntity {
    private int idCustomers;
    private int idStudio;
    private CustomersEntity customers;
    private StudioEntity studios;

    @Id
    @Column(name = "id_customers", nullable = false)
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
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

        FollowerStudioEntity that = (FollowerStudioEntity) o;

        if (idCustomers != that.idCustomers) return false;
        if (idStudio != that.idStudio) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCustomers;
        result = 31 * result + idStudio;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_customers", referencedColumnName = "id", nullable = false)
    public CustomersEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomersEntity customersByIdCustomers) {
        this.customers = customersByIdCustomers;
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
