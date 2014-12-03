package beans;

import entities.Job;
import entities.Person;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Vitaly
 */
@ManagedBean(name = "jobBean")
@ViewScoped
public class JobBean implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;    
    
    public List<Job> getJobs() {
        return em.createQuery("select c from Job c", Job.class).getResultList();
    }
    
    public Map<Integer,String> getNamesOfJobs(){
        Map<Integer,String> result = new LinkedHashMap<>();
        List<Job> companyList = getJobs();
        for(Job j:companyList){
            result.put(j.getJob_id(),j.getName());
        }
        return result;
    }

    public void deleteJob(String jId) {
        if (jId == null) {
            return;
        }
        try {
            utx.begin();
            Job c = em.find(Job.class, jId);
            if(c!= null) {
                em.remove(c);
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
    
    public void createJob(JobEditBean newJ){
        if (newJ == null || newJ.getJob_id() == null) {     
            return;
        }
        try {
            utx.begin();
            Job j = new Job();
            j.setJob_id(newJ.getJob_id());
            j.setName(newJ.getName());
            
            if(j!= null) {
                em.persist(j);
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
    public Job findJob(Integer job_id){
        return em.find(Job.class, job_id);
    }
}
