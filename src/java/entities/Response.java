package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Хасан on 16.11.2014.
 */
@Entity
@Table(name ="responses")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer response_id;
    private String  text;
    private Integer persons_person_id;
    private Integer companies_company_id;
    private Integer jobs_job_id;

    public Response() {
    }
    

    public Response(Integer response_id, String text, Integer persons_person_id, Integer companies_company_id, Integer jobs_job_id) {
        this.response_id = response_id;
        this.text = text;
        this.persons_person_id = persons_person_id;
        this.companies_company_id = companies_company_id;
        this.jobs_job_id = jobs_job_id;
    }

    public Integer getResponse_id() {
        return response_id;
    }

    public void setResponse_id(Integer response_id) {
        this.response_id = response_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPersons_person_id() {
        return persons_person_id;
    }

    public void setPersons_person_id(Integer persons_person_id) {
        this.persons_person_id = persons_person_id;
    }

    public Integer getCompanies_company_id() {
        return companies_company_id;
    }

    public void setCompanies_company_id(Integer companies_company_id) {
        this.companies_company_id = companies_company_id;
    }

    public Integer getJobs_job_id() {
        return jobs_job_id;
    }

    public void setJobs_job_id(Integer jobs_job_id) {
        this.jobs_job_id = jobs_job_id;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (response_id != null ? response_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Response other = (Response) object;
        if ((this.response_id== null && other.response_id != null)
                || (this.response_id != null && !this.response_id.equals(other.response_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interviewJavaProject.Country[ id=" + response_id + " ]";
    }
}
