package data;

import com.sun.org.apache.xpath.internal.SourceTree;
import entities.Company;
import entities.Job;
import entities.Person;
import entities.Response;
import org.w3c.dom.Element;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Хасан on 16.11.2014.
 */
public class Storage {

    static Map<Integer, Person> personMap = new HashMap<Integer, Person>();
//    static Map<Integer, Company> companyMap = new HashMap<Integer, Company>();
//    static Map<Integer, Job> jobMap = new HashMap<Integer, Job>();
//    static Map<Integer, Response> responseMap = new HashMap<Integer, Response>();

    public static String Persons_ROOT = "tables";
    public static String Persons_ELEMENT = "persons";

    public void add() {
        try {
            Person p = new Person();
            Scanner s = new Scanner(System.in);
            System.out.println("Введите id of person");
            p.setPerson_id(s.next());
            System.out.println("Enter First name");
            p.setFirst_name(s.next());
            System.out.println("Enter Last name");
            p.setLast_name(s.next());
            System.out.println("Enter rating");
            p.setRating(s.next());
            System.out.println("Enter age");
            p.setAge(s.next());
            System.out.println("Enter status");
            p.setStatus(s.next());
            System.out.println("Enter login");
            p.setLast_name(s.next());
            System.out.println("Enter password");
            p.setPassword(s.next());
            System.out.println("Enter email");
            p.setEmail(s.next());
            System.out.println("Enter company id");
            p.setCompanies_company_id(s.next());
            System.out.println("Enter job id");
            p.setJobs_job_id(s.next());
            personMap.put(p.getPerson_id(), p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void list() {
        for (Map.Entry<Integer, Person> entry : personMap.entrySet()) {
            int key = entry.getKey();
            Person value = entry.getValue();
            System.out.println(value.toString());
        }
    }

    public void remove(int id) {
        personMap.remove(id);
    }

    public static void fillPersons(Map<Integer, Person> persons) {
        personMap = persons;
    }

//    public static void fillCountries(Map<String, Country> countries){
//        Storage.countries = countries;
//    }
//
//    public static void fillLocations(Map<Long, Location> locations){
//        Storage.locations = locations;
//    }
//
//    public static void fillJobs(Map<String, Job> jobs){
//        Storage.jobs = jobs;
//    }
//
//    public static void fillDepartments(Map<Long, Department> departments){
//        Storage.departments = departments;
//    }
    public static Set<Map.Entry<Integer, Person>> getPersons() {
        return personMap.entrySet();
    }

//    public static Set<Map.Entry<String, Country>> getCountries(){
//        return countries.entrySet();
//    }
//
//    public static Set<Map.Entry<Long, Department>> getDepartments(){
//        return departments.entrySet();
//    }
//
//    public static Set<Map.Entry<String, Job>> getJobs(){
//        return jobs.entrySet();
//    }
//
//    public static Set<Map.Entry<Long, Location>> getLocations(){
//        return locations.entrySet();
}
