package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FollowerStudioEntityPK implements Serializable {
    private int idCustomers;
    private int idStudio;

    @Column(name = "id_customers", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    @Column(name = "id_studio", nullable = false, insertable = false, updatable = false)
    @Id
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

        FollowerStudioEntityPK that = (FollowerStudioEntityPK) o;

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
}
