package databasemanager;

public class Building {
    // Private Members
    private String name;
    private String buildingNum;

    // Constructors
    public Building() {
    }

    public Building(String name, String buildingNum) {
        this.name = name;
        this.buildingNum = buildingNum;
    }

    // Public Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }
}
