package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Хасан on 16.11.2014.
 */
 @Entity 
 @Table(name = "jobs")
public class Job  implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer job_id;
    private String name;
    
    public Job(){}

   
    public Job(int job_id, String name) {
        this.job_id = job_id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJob_id() {

        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (job_id != null ? job_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.job_id == null && other.job_id != null)
                || (this.job_id != null && !this.job_id.equals(other.job_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interviewJavaProject.Country[ id=" + job_id + " ]";
    }
}
