package databasemanager;

public class Room {
    // Private Members
    private String buildingNum; // Foreign Key
    private  String roomNum;    // Primary Key
    private String floorNum;
    private String roomType;
    private String description;
    private String facultyID;

    // Constructors
    public Room() {

    }

    /**
     * Models information related to a room to be stored in the Firebase Realtime Database
     * @param buildingNum Building number
     * @param roomNum Room number
     * @param floorNum Floor number
     * @param roomType The type of room this is(Office, Classroom, Restroom, etc.)
     * @param description Description
     */
    public Room(String buildingNum, String roomNum, String floorNum, String roomType, String description) {
        this.buildingNum = buildingNum;
        this.roomNum = roomNum;
        this.floorNum = floorNum;
        this.roomType = roomType;
        this.description = description;
        this.facultyID = "No Faculty Member";
    }

    /**
     * Models information related to a room to be stored in the Firebase Realtime Database
     * @param buildingNum Building number
     * @param roomNum Room number
     * @param floorNum Floor number
     * @param roomType The type of room this is (Office, Classroom, Restroom, etc.)
     * @param description Description
     * @param facultyID ID of the faculty member in this room
     */
    public Room(String buildingNum, String roomNum, String floorNum, String roomType, String description, String facultyID) {
        this.buildingNum = buildingNum;
        this.roomNum = roomNum;
        this.floorNum = floorNum;
        this.roomType = roomType;
        this.description = description;
        this.facultyID = facultyID;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacultyID() {
        return facultyID;
    }

    /**
     * Faculty ID must be the unique ID that a faculty member is stored under in the database
     * @param facultyID Faculty member ID
     */
    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }
}
