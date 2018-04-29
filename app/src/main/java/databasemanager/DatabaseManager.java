package databasemanager;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import fourloops.scavenger.ListItem;

public final class DatabaseManager {
    // Private Members
    // Refs
    private static final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final DatabaseReference ref = database.getReference();
    private static final DatabaseReference buildingsRef = ref.child("buildings");
    private static final DatabaseReference coursesRef = ref.child("courses");
    private static final DatabaseReference facultyRef = ref.child("faculty");
    private static final DatabaseReference roomRef = ref.child("room");
    private static final DatabaseReference classroomsRef = ref.child("classrooms");
    private static final DatabaseReference officesRef = ref.child("offices");
    private static final DatabaseReference elevatorsRef = ref.child("elevators");
    private static final DatabaseReference stairwaysRef = ref.child("stairways");

    // Class Types
    private static final String Classroom_Type = "01";
    private static final String Office_Type = "02";
    private static final String Stairway_Type = "04";
    private static final String Elevator_Type = "05";

    // Private constructor for non-instantiability
    private DatabaseManager() {
        throw new AssertionError();
    }

    public static void insertBuilding(Building _building) {
        String key = buildingsRef.push().getKey();
        buildingsRef.child(key).setValue(_building);
    }

    public static String insertBuilding(String _name, String _buildingNum) {
        Building newBuilding = new Building(_name, _buildingNum);
        String key = buildingsRef.push().getKey();
        buildingsRef.child(key).setValue(newBuilding);

        return key;
    }

    public static void insertCourse(Course _course) {
        String key = coursesRef.push().getKey();
        coursesRef.child(key).setValue(_course);
    }

    public static String insertCourse(String _crn, String _buildingNum, String _roomNum, String _instructor, String _subject, String _courseNum, String _name, String _startingTime, String _endingTime) {
        Course newCourse = new Course(_crn, _buildingNum, _roomNum, _instructor, _subject, _courseNum, _name, _startingTime, _endingTime);
        String key = coursesRef.push().getKey();
        coursesRef.child(key).setValue(newCourse);

        return key;
    }

    public static void insertFaculty(Faculty _faculty) {
        String key = facultyRef.push().getKey();
        facultyRef.child(key).setValue(_faculty);
    }

    public static String insertFaculty(String _firstName, String _lastName, String _emailAddress) {
        String key = facultyRef.push().getKey();
        Faculty newFaculty = new Faculty(key, _firstName, _lastName, _emailAddress);
        facultyRef.child(key).setValue(newFaculty);

        return key;
    }

    public static void insertRoom(Room _room) {
        String key = roomRef.push().getKey();
        roomRef.child(key).setValue(_room);
    }

    public static String insertRoom(String _buildingNum, String _roomNum, String _floorNum, String _roomType, String _description, String _facultyID) {
        Room newRoom = new Room(_buildingNum, _roomNum, _floorNum, _roomType, _description, _facultyID);
        String key = roomRef.push().getKey();
        roomRef.child(key).setValue(newRoom);

        return key;
    }

    public static void insertClassroom(Classroom _classroom) {
        String key = classroomsRef.push().getKey();
        classroomsRef.child(key).setValue(_classroom);
    }

    public static String insertClassroom(String _buildingNum, String _roomNum, String _floorNum) {
        Classroom newClasroom = new Classroom(_buildingNum, _roomNum, _floorNum);
        String key = classroomsRef.push().getKey();
        classroomsRef.child(key).setValue(newClasroom);

        return key;
    }

    public static void insertOffice(Office _office) {
        String key = officesRef.push().getKey();
        officesRef.child(key).setValue(_office);
    }

    public static String insertOffice(String _buildingNum, String _roomNum, String _floorNum, String _instructor, HashMap<String, String> _hours) {
        Office newOffice = new Office(_buildingNum, _roomNum, _floorNum, _instructor, _hours);
        String key = officesRef.push().getKey();
        officesRef.child(key).setValue(newOffice);

        return key;
    }

    public static void insertElevator(Elevator _elevator) {
        String key = elevatorsRef.push().getKey();
        elevatorsRef.child(key).setValue(_elevator);
    }

    public static String insertElevator(String _buildingNum, String _roomNum) {
        Elevator newElevator = new Elevator(_buildingNum, _roomNum);
        String key = elevatorsRef.push().getKey();
        elevatorsRef.child(key).setValue(newElevator);

        return key;
    }

    public static void insertStairway(Stairway _stairway) {
        String key = stairwaysRef.push().getKey();
        stairwaysRef.child(key).setValue(_stairway);
    }

    public static String insertStairway(String _buildingNum, String _roomNum, String _floorNum) {
        Stairway newStairway = new Stairway(_buildingNum, _roomNum, _floorNum);
        String key = stairwaysRef.push().getKey();
        stairwaysRef.child(key).setValue(newStairway);

        return key;
    }

    public static void getInfo(String key, final ArrayList<ListItem> itemList, final RecyclerView.Adapter adapter) {
        // Example key: 01:00004:003:00305
        List<String> keyList = Arrays.asList(key.split(":"));
        if(keyList.size() < 4)
            throw new IllegalArgumentException("The passed in key is formatted incorrectly.");

        // Parse key
        String type = keyList.get(0);
        final String buildingNum = keyList.get(1);
        String floorNum = keyList.get(2);
        String roomNum = keyList.get(3);

        // Classroom
        if(type.equals(Classroom_Type)) {
            // Get the building info
            buildingsRef.orderByChild("buildingNum")
                    .equalTo(buildingNum)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                Building buildingData = ds.getValue(Building.class);

                                // Check if already in the list
                                boolean exists = false;
                                for (ListItem item : itemList) {
                                    // If the building name already exists update it's value.
                                    if (item.getItemTitle().equals("Building Name")) {
                                        item.setItemBody(buildingData.getName());
                                        exists = true;
                                        adapter.notifyDataSetChanged();
                                    }
                                }

                                // If the building name does not exist add it to the view.
                                if (!exists) {
                                    ListItem building_ListItem = new ListItem("Building Name", buildingData.getName());
                                    itemList.add(building_ListItem);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            String error = databaseError.getMessage();
                            Log.v("Database", error);
                        }
                    });

            // Get the classroom
            roomRef.orderByChild("roomNum")
                    .equalTo(roomNum)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                Room classroomData = ds.getValue(Room.class);

                                // Check if already in the list
                                boolean exists = false;
                                for (ListItem item : itemList) {
                                    // If the room number already exists update it's value.
                                    if (item.getItemTitle().equals("Room Number")) {
                                        item.setItemBody(classroomData.getRoomNum());
                                        exists = true;
                                        adapter.notifyDataSetChanged();
                                    }
                                }

                                // If the room number is not in the list add it to the view
                                if (!exists) {
                                    ListItem class_ListItem = new ListItem("Room Number", classroomData.getRoomNum());
                                    itemList.add(class_ListItem);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            String error = databaseError.getMessage();
                            Log.v("Database", error);
                        }
                    });

            // Get the course info
            coursesRef.orderByChild("roomNum")
                    .equalTo(roomNum)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            ArrayList<String> courseList = new ArrayList<String>();
                            final ArrayList<String> instructorList = new ArrayList<String>();
                            final ArrayList<String> emailList = new ArrayList<String>();
                            final ArrayList<String> facultyKeys = new ArrayList<String>();

                            // Get the keys for all teachers who teach in this classroom.
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                Course courseData = ds.getValue(Course.class);

                                // Append the course to the course list
                                String course = courseData.getSubject() + courseData.getCourseNum() + ": " + courseData.getName() + "\n\tStart Time: " + courseData.getStartingTime() + "\n\tEnd Time: " + courseData.getEndingTime() + "\n\n";
                                courseList.add(course);

                                // Append the instructor to the instructor list
                                facultyKeys.add(courseData.getInstructor());
                            }


                            // Loop through the teachers
                            for (int i = 0; i < facultyKeys.size(); i++) {
                                final int localI = i;
                                facultyRef.orderByChild("id")
                                        .equalTo(facultyKeys.get(i))
                                        .addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                                    Faculty faculty = ds.getValue(Faculty.class);

                                                    // Get full name
                                                    ArrayList<String> fullName = new ArrayList<String>();
                                                    fullName.add(faculty.getFirstName());
                                                    fullName.add(faculty.getLastName());

                                                    String instructor_FullName = TextUtils.join(" ", fullName);
                                                    instructorList.add(instructor_FullName);

                                                    // Add email
                                                    emailList.add(faculty.getEmailAddress());

                                                    // Ensure we have all the emails. TODO: Possible bug here involving real-time data retrieval
                                                    if (emailList.size() == facultyKeys.size()) {
                                                        // Add instructors
                                                        String instructors = TextUtils.join("\n", instructorList);
                                                        // Check if already in the list
                                                        boolean instructorExists = false;
                                                        for (ListItem item : itemList) {
                                                            // If the instructor is already in the list just update it's value.
                                                            if (item.getItemTitle().equals("Instructors")) {
                                                                item.setItemBody(instructors);
                                                                instructorExists = true;
                                                                adapter.notifyDataSetChanged();
                                                            }
                                                        }
                                                        // If this is a new instructor add it to the view.
                                                        if (!instructorExists) {
                                                            ListItem instructor_ListItem = new ListItem("Instructors", instructors);
                                                            itemList.add(instructor_ListItem);
                                                            adapter.notifyDataSetChanged();
                                                        }

                                                        // Add emails
                                                        String emails = TextUtils.join("\n", emailList);
                                                        // Check if already in the list
                                                        boolean emailExists = false;
                                                        for (ListItem item : itemList) {
                                                            // If the email is already in the list update it's value.
                                                            if (item.getItemTitle().equals("Instructor Emails")) {
                                                                item.setItemBody(emails);
                                                                emailExists = true;
                                                                adapter.notifyDataSetChanged();
                                                            }
                                                        }
                                                        // If this is a new email add it to the view.
                                                        if (!emailExists) {
                                                            ListItem email_ListItem = new ListItem("Instructor Emails", emails);
                                                            itemList.add(email_ListItem);
                                                            adapter.notifyDataSetChanged();
                                                        }
                                                    }
                                                }
                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {
                                                String error = databaseError.getMessage();
                                                Log.v("Database", error);
                                            }
                                        });
                            }

                            // Add courses
                            String courses = TextUtils.join(" ", courseList);
                            // Check if already in the list
                            boolean exists = false;
                            for (ListItem item : itemList) {
                                // If the course is already in the view just update it.
                                if (item.getItemTitle().equals("Courses")) {
                                    item.setItemBody(courses);
                                    exists = true;
                                    adapter.notifyDataSetChanged();
                                }
                            }
                            // If this is a new course add it to the view.
                            if (!exists) {
                                ListItem courses_ListItem = new ListItem("Courses", courses);
                                itemList.add(courses_ListItem);
                                adapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            String error = databaseError.getMessage();
                            Log.v("Database", error);
                        }
                    });
        }

        // Office
        if(type.equals(Office_Type)) {
            // Get the building info
            buildingsRef.orderByChild("buildingNum")
                    .equalTo(buildingNum)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                Building buildingData = ds.getValue(Building.class);

                                // Check if already in the list
                                boolean exists = false;
                                for (ListItem item : itemList) {
                                    // If the building name already exists update it's value.
                                    if (item.getItemTitle().equals("Building Name")) {
                                        item.setItemBody(buildingData.getName());
                                        exists = true;
                                        adapter.notifyDataSetChanged();
                                    }
                                }

                                // If the building name does not exist add it to the view.
                                if (!exists) {
                                    ListItem building_ListItem = new ListItem("Building Name", buildingData.getName());
                                    itemList.add(building_ListItem);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            String error = databaseError.getMessage();
                            Log.v("Database", error);
                        }
                    });

            // Get the classroom
            roomRef.orderByChild("roomNum")
                    .equalTo(roomNum)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String facultyID = "None";

                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                Room roomData = ds.getValue(Room.class);
                                facultyID = roomData.getFacultyID();

                                // Check if already in the list
                                boolean roomNum_Exists = false, roomType_Exists = false,
                                        description_Exists = false;
                                for (ListItem item : itemList) {
                                    // Check if values are already in the view
                                    if (item.getItemTitle().equals("Room Number")) {
                                        item.setItemBody(roomData.getRoomNum());
                                        roomNum_Exists = true;
                                        adapter.notifyDataSetChanged();
                                    }
                                    if (item.getItemTitle().equals("Room Type")) {
                                        item.setItemBody(roomData.getRoomType());
                                        roomType_Exists = true;
                                        adapter.notifyDataSetChanged();
                                    }
                                    if (item.getItemTitle().equals("Description")) {
                                        item.setItemBody(roomData.getDescription());
                                        description_Exists = true;
                                        adapter.notifyDataSetChanged();
                                    }
                                }

                                // If the room number is not in the list add it to the view
                                if (!roomNum_Exists) {
                                    ListItem class_ListItem = new ListItem("Room Number", roomData.getRoomNum());
                                    itemList.add(class_ListItem);
                                    adapter.notifyDataSetChanged();
                                }
                                if(!roomType_Exists) {
                                    ListItem class_ListItem = new ListItem("Room Type", roomData.getRoomType());
                                    itemList.add(class_ListItem);
                                    adapter.notifyDataSetChanged();
                                }
                                if(!description_Exists) {
                                    ListItem class_ListItem = new ListItem("Description", roomData.getDescription());
                                    itemList.add(class_ListItem);
                                    adapter.notifyDataSetChanged();
                                }
                            }

                            // Get the faculty information
                            facultyRef.orderByChild("id")
                                    .equalTo(facultyID)
                                    .addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                                Faculty faculty = ds.getValue(Faculty.class);

                                                // Get full name
                                                ArrayList<String> fullName = new ArrayList<String>();
                                                fullName.add(faculty.getFirstName());
                                                fullName.add(faculty.getLastName());

                                                String instructor_FullName = TextUtils.join(" ", fullName);

                                                boolean instructorExists = false;
                                                for (ListItem item : itemList) {
                                                    // If the instructor is already in the list just update it's value.
                                                    if (item.getItemTitle().equals("Faculty")) {
                                                        item.setItemBody(instructor_FullName);
                                                        instructorExists = true;
                                                        adapter.notifyDataSetChanged();
                                                    }
                                                }
                                                // If this is a new instructor add it to the view.
                                                if (!instructorExists) {
                                                    ListItem instructor_ListItem = new ListItem("Faculty", instructor_FullName);
                                                    itemList.add(instructor_ListItem);
                                                    adapter.notifyDataSetChanged();
                                                }

                                                // Add emails
                                                boolean emailExists = false;
                                                for (ListItem item : itemList) {
                                                    // If the email is already in the list update it's value.
                                                    if (item.getItemTitle().equals("Email")) {
                                                        item.setItemBody(faculty.getEmailAddress());
                                                        emailExists = true;
                                                        adapter.notifyDataSetChanged();
                                                    }
                                                }
                                                // If this is a new email add it to the view.
                                                if (!emailExists) {
                                                    ListItem email_ListItem = new ListItem("Email", faculty.getEmailAddress());
                                                    itemList.add(email_ListItem);
                                                    adapter.notifyDataSetChanged();
                                                }

                                            }
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            String error = databaseError.getMessage();
                                            Log.v("Database", error);
                                        }
                                    });

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            String error = databaseError.getMessage();
                            Log.v("Database", error);
                        }
                    });

        }


    }
}
