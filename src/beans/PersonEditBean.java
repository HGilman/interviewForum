package beans;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Хасан on 15.11.2014.
 */
@ViewScoped
@ManagedBean
public class PersonEditBean {
    @Id
    private Integer person_id;
    private String first_name;
    private String last_name;
    private float rating;
    private int age;
    private String status;
    private String login;
    private String password;
    private String email;
    private int companies_company_id;
    private int jobs_job_id;

    public PersonEditBean(){}

    public  PersonEditBean(Integer person_id, String first_name, String last_name, float rating, int age, String status, String login, String password, String email, int companies_company_id, int jobs_job_id) {
        this.person_id = person_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.rating = rating;
        this.age = age;
        this.status = status;
        this.login = login;
        this.password = password;
        this.email = email;
        this.companies_company_id = companies_company_id;
        this.jobs_job_id = jobs_job_id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public float getRating() {
        return rating;
    }

    public int getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getCompanies_company_id() {
        return companies_company_id;
    }

    public int getJobs_job_id() {
        return jobs_job_id;
    }

    public void setPerson_id(String p_id){
        this.person_id = Integer.parseInt(p_id);
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setRating(Float rating){
        this.rating = rating;
    }
     public void setAge(int age){
         this.age = age;
     }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompanies_company_id(String companies_company_id){
        this.companies_company_id = Integer.parseInt(companies_company_id);
    }

    public void setJobs_job_id(String jobs_job_id){
        this.jobs_job_id = Integer.parseInt(jobs_job_id);
    }  
}