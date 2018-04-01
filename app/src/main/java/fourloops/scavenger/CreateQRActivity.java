package fourloops.scavenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;

public class CreateQRActivity extends AppCompatActivity {

    EditText roomNumInput;
    EditText floorNumInput;
    EditText buildingNumInput;
    String roomNum, buildingNum, floorNum, jsonSender;
    URL url;

    private FirebaseDatabase myDatabase;
    private FirebaseAuth myAuth;
    private DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);


        roomNumInput = (EditText) findViewById(R.id.roomNumInput);
        floorNumInput = (EditText) findViewById(R.id.floorNumInput);
        buildingNumInput = (EditText) findViewById(R.id.buildingNumInput);



    }

    public void onCreateRoomTap(View v) throws IOException {
        Log.i("myapp","hello world");
        buildingNum = buildingNumInput.getText().toString();
        roomNum = roomNumInput.getText().toString();
        floorNum = floorNumInput.getText().toString();
        jsonSender = "{" + "\"buildingNum\":\"" + buildingNum + "\",\"" + "floorNum\":\"" + floorNum + "\",\"roomNum\":\"" + roomNum + "\"}";
        Log.i("myapp",jsonSender);

        HttpClient c = new DefaultHttpClient();
        Log.i("myapp","1");
        HttpPost p = new HttpPost("https://capstone-forloops-scavenger.firebaseio.com/classrooms/.json");
        Log.i("myapp","2");
        StringEntity se = new StringEntity(jsonSender,"UTF-8");
        se.setContentType("application/json; charset=UTF-8");
        p.setEntity(se);
        Log.i("myapp","3");
        //HttpResponse r = c.execute(p);
        Log.i("myapp","4");
       // HttpEntity e = r.getEntity();
        Log.i("myapp","5");
      //  String response = EntityUtils.toString(e,"UTF-8");
      //  Log.i("myapp",response);

    }

}
