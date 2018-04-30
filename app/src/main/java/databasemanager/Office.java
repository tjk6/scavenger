package databasemanager;

import java.util.HashMap;

/**
 * Created by Jeremy on 3/13/2018.
 */

public class Office {
    // Private Members
    private String buildingNum; // Foreign Key
    private  String roomNum;    // Primary Key
    private String floorNum;
    private String instructor;
    private HashMap<String, String> hours;

    // Constructors
    public Office() {

    }

    /**
     * Models information related to an office to be stored in the Firebase Realtime Database
     * @param buildingNum Building number
     * @param roomNum Room number
     * @param floorNum Floor number
     * @param instructor ID of the faculty member in this office
     * @param hours Hashmap containing the faculty member's office hours
     */
    public Office(String buildingNum, String roomNum, String floorNum, String instructor, HashMap<String, String> hours) {
        this.buildingNum = buildingNum;
        this.roomNum = roomNum;
        this.floorNum = floorNum;
        this.instructor = instructor;
        this.hours = hours;
    }

    // Public Methods
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

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public String getInstructor() {
        return instructor;
    }

    /**
     * Unique ID of the faculty member who owns this office. This should be the same ID that the faculty member
     * is stored in the database under.
     * @param instructor Unique ID of the faculty member.
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public HashMap<String, String> getHours() {
        return hours;
    }

    /**
     * Hashmap representation of the office hours of the faculty member in the office.
     * Example:
     *          (1200, 1500)
     * Note:
     *          Office hours must be in 24-hour notation.
     * @param hours Hashmap containing office hours
     */
    public void setHours(HashMap<String, String> hours) {
        this.hours = hours;
    }

    /**
     * Adds a range into the office hours of the faculty member in the office.
     * Note:
     *          Office hours must be in 24-hour notation.
     * @param startingTime Starting time
     * @param endingTime Ending time
     */
    public void insertHours(String startingTime, String endingTime) {
        hours.put(startingTime, endingTime);
    }
}
