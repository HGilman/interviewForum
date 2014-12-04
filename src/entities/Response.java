package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Хасан on 16.11.2014.
 */
@Entity
@Table(name ="responses")
public class Response {
    @Id
    private int response_id;
    private int person_id;
    private String text;
    private int persons_person_id;

    public Response(){}

    public Response(int response_id, int person_id, String text, int persons_person_id) {
        this.response_id = response_id;
        this.person_id = person_id;
        this.text = text;
        this.persons_person_id = persons_person_id;
    }

    public int getResponse_id() {
        return response_id;
    }

    public void setResponse_id(int response_id) {
        this.response_id = response_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPersons_person_id() {
        return persons_person_id;
    }

    public void setPersons_person_id(int persons_person_id) {
        this.persons_person_id = persons_person_id;
    }
}
