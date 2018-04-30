package databasemanager;

public class Faculty {
    // Private Members
    private String id;          // Primary Key
    private String firstName;
    private String lastName;
    private String emailAddress;

    // Constructors
    public Faculty() {

    }

    /**
     * Models information related to a faculty member to be stored in the Firebase Realtime Database
     * @param id Unique ID to store the faculty member under. It is recommended that this ID be generated using
     *           the Firebase API's getKey() function.
     * @param firstName First name
     * @param lastName Last name
     * @param emailAddress Email address
     */
    public Faculty(String id, String firstName, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    // Public Methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    /**
     * Unique ID to store the faculty member under. It is recommended that this ID be generated using
     * the Firebase API's getKey() function.
     * @param id Unique ID of the faculty member.
     */
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
