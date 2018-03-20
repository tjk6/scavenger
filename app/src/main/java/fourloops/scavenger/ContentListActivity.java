package fourloops.scavenger;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Tyler on 3/20/2018.
 */

public class ContentListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_list);

        ArrayList<ListItem> itemList = new ArrayList<>();
        itemList.add(new ListItem("Building", "4")); //Change these to be variable;
        itemList.add(new ListItem("Floor", "3")); //Change these to be variable;
        itemList.add(new ListItem("Room", "304")); //Change these to be variable;
    }
}
