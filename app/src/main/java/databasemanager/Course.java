package databasemanager;

public class Course {
    // Private Members
    private String crn;
    private String name;
    private String startingTime;
    private String endingTime;

    // Constructors
    public Course() {
    }

    public Course(String crn, String name, String startingTime, String endingTime) {
        this.crn = crn;
        this.name = name;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    // Public Methods
    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

}
