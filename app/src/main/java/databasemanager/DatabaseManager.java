package databasemanager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    private static final DatabaseReference classroomsRef = ref.child("classrooms");
    private static final DatabaseReference officesRef = ref.child("offices");
    private static final DatabaseReference elevatorsRef = ref.child("elevators");
    private static final DatabaseReference stairwaysRef = ref.child("stairways");


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

    public static void insertClassroom(Classroom _classroom) {
        String key = classroomsRef.push().getKey();
        classroomsRef.child(key).setValue(_classroom);
    }

    public static void insertOffices(Office _office) {
        String key = officesRef.push().getKey();
        officesRef.child(key).setValue(_office);
    }

    public static void insertElevator(Elevator _elevator) {
        String key = elevatorsRef.push().getKey();
        elevatorsRef.child(key).setValue(_elevator);
    }

    public static void insertStairway(Stairway _stairway) {
        String key = stairwaysRef.push().getKey();
        stairwaysRef.child(key).setValue(_stairway);
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

        buildingsRef.orderByChild("buildingNum")
                    .equalTo(buildingNum)
                    .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
