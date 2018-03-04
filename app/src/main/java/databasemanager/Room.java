package databasemanager;

public class Room {
    // Private Members
    private  String roomNum;
    private String floorNum;

    // Constructors
    public Room() {
    }

    public Room(String roomNum, String floorNum) {
        this.roomNum = roomNum;
        this.floorNum = floorNum;
    }

    // Public Methods
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
