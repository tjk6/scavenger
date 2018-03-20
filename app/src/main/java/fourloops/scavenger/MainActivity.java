package fourloops.scavenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import databasemanager.DatabaseManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        String buildingKey = DatabaseManager.insertBuilding("Hal Marcus College of Science and Engineering", "00004");
//        String facultyKey = DatabaseManager.insertFaculty("Bernd", "Owsnicki-Klewe", "bowsnickiklewe@uwf.edu");
//        String courseKey = DatabaseManager.insertCourse("11845", "00004", "00305", facultyKey, "CIS", "4592", "Capstone", "1100", "1215");
//        HashMap<String, String> officeHours = new HashMap<>();
//        officeHours.put("0945", "1200");
//        String officeKey = DatabaseManager.insertOffice("00004", "00245", "2", facultyKey, officeHours);
//        String classroomKey = DatabaseManager.insertClassroom("00004", "00305", "003");

        
        JSONObject json = DatabaseManager.getInfo("01:00004:003:00305:TEST_CLASS");

//        try
//        {
//            TimeUnit.SECONDS.sleep(10);
//        }
//        catch(InterruptedException ex)
//        {
//            ex.printStackTrace();
//        }

        int test = 5;
    }
}
