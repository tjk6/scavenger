package databasemanager;

public class Room {
    // Private Members
    private String buildingNum; // Foreign Key
    private  String roomNum;    // Primary Key
    private String floorNum;

    // Constructors
    public Room() {

    }

    public Room(String buildingNum, String roomNum, String floorNum) {
        this.buildingNum = buildingNum;
        this.roomNum = roomNum;
        this.floorNum = floorNum;
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
}
