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

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public HashMap<String, String> getHours() {
        return hours;
    }

    public void setHours(HashMap<String, String> hours) {
        this.hours = hours;
    }

    public void insertHours(String startingTime, String endingTime) {
        hours.put(startingTime, endingTime);
    }
}
