/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entities.Person;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;



/**
 *
 * @author Хасан
 */
@ManagedBean
@ViewScoped
public class PersonBean implements Serializable{
    
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;
    
    public List<Person> getPersons(){
        return em.createQuery("SELECT p FROM Person", Person.class).getResultList();
    }
    
    public void deletePerson(String pId) {
        if (pId == null) {
            return;
        }
        try {
            utx.begin();
            Person p = em.find(Person.class, pId);
            if(p!= null) {
                em.remove(p);
            }
            
            utx.commit();
        }   catch (Exception ex) {
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
    public void createCountry(PersonEditBean newP){
        if (newP == null || newP.getPerson_id() == null) {     
            return;
        }
        try {
            utx.begin();
            Person person = new Person();
            person.setPerson_id(newP.getPerson_id());
            person.setFirst_name(newP.getFirst_name());
            person.setLast_name(newP.getLast_name());
            person.setRating(newP.getRating());
            person.setAge(newP.getAge());
            person.setStatus(newP.getStatus());
            person.setLogin(newP.getLogin());
            person.setPassword(newP.getPassword());
            person.setEmail(newP.getEmail());
            person.setCompanies_company_id(newP.getCompanies_company_id());
            person.setJobs_job_id(newP.getJobs_job_id());
            
            if(person!= null) {
                em.persist(person);
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
