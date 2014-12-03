/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Person;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Хасан
 */
@ManagedBean(name = "connectedPerson")
@ViewScoped
public class connectedPersonBean implements Serializable{
    @PersistenceContext
    private EntityManager em;
    
    private Person connectedPerson;
    private String email;
    private String password;
    
    public connectedPersonBean() {
    }
    
    public connectedPersonBean(String email, String password) {
       this.email = email;
       this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Person getConnectedPerson() {
        return connectedPerson;
    }

//    public void setConnectedPerson() {
//        PersonBean pBean = new PersonBean();
//        this.connectedPerson = pBean.getAutorizedPerson(email, password);
//    }
    
    
    public void setConnectedPerson(){
     Query query = em.createQuery("select p from Person p where p.email =:email AND p.password =:password", Person.class);
     query.setParameter("email", email);
     query.setParameter("password", password);
     this.connectedPerson = (Person)query.getResultList().get(0);
    } 
    
    public void setConnectedPerson(Person p ) {
        this.connectedPerson = p;
    }
    
}
