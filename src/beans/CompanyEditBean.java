package beans;

import entities.Company;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Хасан on 16.11.2014.
 */
@ViewScoped
@ManagedBean
public class CompanyEditBean implements Serializable {
    @Id
    private Integer company_id;
    private String name;

    public CompanyEditBean() {
    }

    public CompanyEditBean(Integer company_id, String name) {
        this.company_id = company_id;
        this.name = name;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
