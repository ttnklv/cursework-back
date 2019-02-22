package com.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FollowerAnalystEntityPK implements Serializable {
    private int idCustomers;
    private int idAnalyst;

    @Column(name = "id_customers", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    @Column(name = "id_analyst", nullable = false, insertable = false, updatable = false)
    @Id
    public int getIdAnalyst() {
        return idAnalyst;
    }

    public void setIdAnalyst(int idAnalyst) {
        this.idAnalyst = idAnalyst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowerAnalystEntityPK that = (FollowerAnalystEntityPK) o;

        if (idCustomers != that.idCustomers) return false;
        if (idAnalyst != that.idAnalyst) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCustomers;
        result = 31 * result + idAnalyst;
        return result;
    }
}
