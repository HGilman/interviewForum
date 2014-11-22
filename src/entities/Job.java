package entities;

/**
 * Created by Хасан on 16.11.2014.
 */
public class Job {
    private int job_id;
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

    public int getJob_id() {

        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }
}
