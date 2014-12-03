/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Company;
import entities.Response;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Vitaly
 */
@ManagedBean(name ="responseBean")
@ViewScoped
public class ResponseBean implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Response> getResponses() {
        return em.createQuery("select r from Response r", Response.class).getResultList();
    }
    
    public List<Response> getSpecialResponses(Integer jobId, Integer companyId) {
        
    Query query = em.createQuery("select r from Response r where r.jobs_job_id = " + jobId +" AND r.companies_company_id = " + companyId, Response.class);
    
    
    return query.getResultList();
        
//        return em.createQuery("SELECT r FROM Response r WHERE r.jobs_job_id:job_id AND r.companies_company_id:company_id").
//                              .setParameter("job_id",jobId,"company_id",companyId);
    }

    public void deleteResponse(String rId) {
        if (rId == null) {
            return;
        }
        try {
            utx.begin();
            Response r = em.find(Response.class, rId);
            if(r!= null) {
                em.remove(r);
            }
            
            utx.commit();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DB Error:", ex.getLocalizedMessage()));
            ex.printStackTrace(System.err);
            try {
                utx.rollback();
            } catch (Exception exc) {
                exc.printStackTrace(System.err);
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DB Error:", exc.getLocalizedMessage()));
            }
        }
    }
    
    public void createResponse(ResponseEditBean newR){
        if (newR == null || newR.getResponse_id() == null) {     
            return;
        }
        try {
            utx.begin();
            Response r = new Response();
            r.setResponse_id(newR.getResponse_id());
            r.setText(newR.getText());
            r.setPersons_person_id(newR.getPersons_person_id());
            r.setCompanies_company_id(newR.getCompanies_company_id());
            r.setJobs_job_id(newR.getJobs_job_id());
            
            if(r!= null) {
                em.persist(r);
            }
            
            utx.commit();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DB Error:", ex.getLocalizedMessage()));
            ex.printStackTrace(System.err);
            try {
                utx.rollback();
            } catch (Exception exc) {              
                exc.printStackTrace(System.err);
            }
        }
    }
}
