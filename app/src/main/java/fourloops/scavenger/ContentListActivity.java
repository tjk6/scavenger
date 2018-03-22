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

        // Get the key from the scanner
        Bundle bundle = getIntent().getExtras();
        String key = bundle.getString("key");

        // Attach the Firebase queries
        ArrayList<ListItem> itemList = new ArrayList<>();
        recyclerAdapter = new DataListAdapter(itemList);
        DatabaseManager.getInfo(key, itemList, recyclerAdapter);

        // Attach the views
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
