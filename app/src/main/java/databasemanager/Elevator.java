package databasemanager;

/**
 * Created by Jeremy on 3/13/2018.
 */

public class Elevator {
    // Private Members
    private String buildingNum; // Foreign Key
    private  String roomNum;    // Primary Key

    // Constructors
    public Elevator() {

    }

    /**
     * Models information related to an elevator to be stored in the Firebase Realtime Database
     * @param buildingNum
     * @param roomNum
     */
    public Elevator(String buildingNum, String roomNum) {
        this.buildingNum = buildingNum;
        this.roomNum = roomNum;
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
}
