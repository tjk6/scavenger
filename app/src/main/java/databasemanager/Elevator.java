package databasemanager;

/**
 * Created by Jeremy on 3/13/2018.
 */

public class Elevator {
    // Private Members
    private String buildingNum; // Foreign Key
    private  String roomNum;    // Primary Key

    // Constructors


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
}
