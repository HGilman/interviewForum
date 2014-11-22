package entities;

/**
 * Created by Хасан on 16.11.2014.
 */
public class Company {
    private int company_id;
    private String name;

    public Company() {
    }

    public Company(int company_id, String name) {
        this.company_id = company_id;
        this.name = name;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
