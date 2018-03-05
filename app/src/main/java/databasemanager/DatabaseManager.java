package databasemanager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public final class DatabaseManager {
    // Private Members
    private static final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final DatabaseReference ref = database.getReference();
    private static final DatabaseReference buildingsRef = ref.child("buildings");
    private static final DatabaseReference coursesRef = ref.child("courses");
    private static final DatabaseReference facultyRef = ref.child("faculty");
    private static final DatabaseReference roomsRef = ref.child("rooms");

    // Private constructor for non-instantiability
    private DatabaseManager() {
        throw new AssertionError();
    }

    public static void insertBuilding(Building _building) {
        String key = buildingsRef.push().getKey();
        buildingsRef.child(key).setValue(_building);
    }

    public static void insertCourse(Course _course) {
        String key = coursesRef.push().getKey();
        coursesRef.child(key).setValue(_course);
    }

    public static void insertFaculty(Faculty _faculty) {
        String key = facultyRef.push().getKey();
        facultyRef.child(key).setValue(_faculty);
    }

    public static void insertRoom(Room _room) {
        String key = roomsRef.push().getKey();
        roomsRef.child(key).setValue(_room);
    }

    public static void getInfo(String key) {
        // Example key: 01:00004:003:00305
        List<String> keyList = Arrays.asList(key.split(":"));
        if(keyList.size() != 4)
            throw new IllegalArgumentException("The passed in key is formatted incorrectly.");

        String type = keyList.get(0);
        String buildingNum = keyList.get(1);
        String floorNum = keyList.get(2);
        String roomNum = keyList.get(3);

        
    }
}
