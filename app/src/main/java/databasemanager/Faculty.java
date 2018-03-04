package databasemanager;

public class Faculty {
    // Private Members
    private String firstName;
    private String middleName;
    private String lastName;
    private String id;
    private String emailAddress;

    // Constructors
    public Faculty() {

    }

    public Faculty(String firstName, String middleName, String lastName, String id, String emailAddress) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.id = id;
        this.emailAddress = emailAddress;
    }

    // Public Methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
