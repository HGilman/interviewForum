package beans;


import entities.Company;
import entities.Job;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name ="companyBean")
@ViewScoped
public class CompanyBean implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Company> getCompanies() {
        return em.createQuery("select c from Company c", Company.class).getResultList();
    }
    
    public Map<Integer,String> getNamesOfCompanies(){
         Map<Integer,String> result = new LinkedHashMap<>();
         List<Company> list = getCompanies();
         for(Company j:list){
         result.put(j.getCompany_id(), j.getName());
         }
         return result;
    }


    public void deleteCompany(String cId) {
        if (cId == null) {
            return;
        }
        try {
            utx.begin();
            Company c = em.find(Company.class, cId);
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
    
    public void createCountry(CompanyEditBean newC){
        if (newC == null || newC.getCompany_id() == null) {     
            return;
        }
        try {
            utx.begin();
            Company c = new Company();
            c.setCompany_id(newC.getCompany_id());
            c.setName(newC.getName());
            
            if(c!= null) {
                em.persist(c);
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
    public Company findCompany(Integer company_id){
        return em.find(Company.class, company_id);
    }
}
