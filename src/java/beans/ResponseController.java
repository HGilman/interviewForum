/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.CompanyBean;
import beans.CompanyEditBean;
import beans.JobBean;
import entities.Company;
import entities.Job;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Хасан
 */
@ManagedBean(name ="responseController")
@SessionScoped
public class ResponseController implements Serializable{
    
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;
    
    private Integer jobId;
    private Integer companyId;
    private String message;
//    private Map<Integer,String> jobMap;
//    private Map<Integer,String> companyMap;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public UserTransaction getUtx() {
        return utx;
    }

    public void setUtx(UserTransaction utx) {
        this.utx = utx;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    
    
    public String getMessage(){
        return message;
    }
    
    
}
