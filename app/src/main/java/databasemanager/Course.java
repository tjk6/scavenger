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

    /**
     * Models information related to a course to be stored in the Firebase Realtime Database
     * @param crn Course reference number
     * @param buildingNum Building number
     * @param roomNum Room number
     * @param faculty ID of faculty member that instructs the course
     * @param subject Subject
     * @param courseNum Course number
     * @param name Name
     * @param startingTime 24-hour start time
     * @param endingTime 24-hour end time
     */
    public Course(String crn, String buildingNum, String roomNum, String faculty, String subject, String courseNum, String name, String startingTime, String endingTime) {
        this.crn = crn;
        this.buildingNum = buildingNum;
        this.roomNum = roomNum;
        this.instructor = faculty;
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

    /**
     * Instructor should be a unique key ID that you plan to store the instructor under in the database.
     * It is recommended that you use the Firebase API's getKey() functionality to generate this ID.
     * @param instructor Unique ID of the instructor
     */
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

    /**
     * Starting time must be in 24-hour notation.
     * @param startingTime Starting time
     */
    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    /**
     * Ending time must be in 24-hour notation.
     * @param endingTime Ending time
     */
    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

}
