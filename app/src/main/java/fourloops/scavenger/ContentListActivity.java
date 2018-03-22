package fourloops.scavenger;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import databasemanager.DatabaseManager;

/**
 * Created by Tyler on 3/20/2018.
 */

public class ContentListActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_list);


        //TODO: You may be able to add a new item to the list each time you update this.
        ArrayList<ListItem> itemList = new ArrayList<>();
        recyclerAdapter = new DataListAdapter(itemList);
        DatabaseManager.getInfo("01:00004:003:00305", itemList, recyclerAdapter);

//        itemList.add(new ListItem("Building", "4")); //Change these to be variable;
//        itemList.add(new ListItem("Floor", "3")); //Change these to be variable;
//        itemList.add(new ListItem("Room", "304")); //Change these to be variable;
//        itemList.add(new ListItem("Description","STORAGE_ROOM"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

    }
}
