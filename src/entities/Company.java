package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Хасан on 16.11.2014.
 */
@Entity
@Table(name = "companies")
public class Company implements Serializable {
    @Id
    private Integer company_id;
    private String name;

    public Company() {
    }

    public Company(int company_id, String name) {
        this.company_id = company_id;
        this.name = name;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (company_id != null ? company_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.company_id == null && other.company_id != null)
                || (this.company_id != null && !this.company_id.equals(other.company_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.Country[ id=" + company_id + " ]";
    }
}
