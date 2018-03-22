package databasemanager;

public class Course {
    // Private Members
    private String crn;         // Primary Key
    private String buildingNum; // Foreign Key
    private String roomNum;     // Foreign Key
    private String instructor;  // Foreign Key
    private String subject;
    private String courseNum;
    private String name;
    private String startingTime;
    private String endingTime;

    // Constructors
    public Course() {

    }

    public Course(String crn, String buildingNum, String roomNum, String instructor, String subject, String courseNum, String name, String startingTime, String endingTime) {
        this.crn = crn;
        this.buildingNum = buildingNum;
        this.roomNum = roomNum;
        this.instructor = instructor;
        this.subject = subject;
        this.courseNum = courseNum;
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

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
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
