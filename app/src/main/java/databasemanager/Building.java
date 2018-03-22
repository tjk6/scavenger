package databasemanager;

public class Building {
    // Private Members
    private String buildingNum; // Primary Key
    private String name;

    // Constructors
    public Building() {

    }

    public Building(String name, String buildingNum) {
        this.buildingNum = buildingNum;
        this.name = name;
    }

    // Public Methods
    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
