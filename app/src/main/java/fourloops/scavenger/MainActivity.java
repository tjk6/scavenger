package fourloops.scavenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton qrLaunchButton;
    private ImageButton qrCreatorButton;
    private ImageButton pinButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrLaunchButton = findViewById(R.id.obj_qr_scanner);

        qrLaunchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchQRScanner();
            }
        });

        qrCreatorButton = findViewById(R.id.create_new_qr);

        qrCreatorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchQRCreator();
            }
        });

        pinButton = findViewById(R.id.bldg_info);

        pinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchBldgInfo();
            }
        });

    }

    private void launchQRScanner(){
        Log.d("Launcher", "Main button was pressed\n");
        Intent intent = new Intent(this, QRScannerActivity.class);
        startActivity(intent);
    }

    private void launchQRCreator(){
        Log.d("Launcher", "Button was pressed\n");
        Intent intent = new Intent(this, ContentListActivity.class);
        startActivity(intent);
    }

    private void launchBldgInfo(){
        Log.d("Launcher", "Bldg Info button was pressed\n");
        Intent intent = new Intent(this, BldgMapActivity.class);
        startActivity(intent);
    }
}
