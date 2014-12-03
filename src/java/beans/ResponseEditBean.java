/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Id;

/**
 *
 * @author Хасан
 */
@ViewScoped
@ManagedBean
public class ResponseEditBean {
    @Id
    private Integer response_id;
    private String text;
    private Integer persons_person_id;
    private Integer companies_company_id;
    private Integer jobs_job_id;

    public ResponseEditBean() {
    }
    

    public ResponseEditBean(Integer response_id, String text, Integer persons_person_id, Integer companies_company_id, Integer jobs_job_id) {
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
}