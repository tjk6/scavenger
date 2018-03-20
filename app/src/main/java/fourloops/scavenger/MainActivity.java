package fourloops.scavenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button qrLaunchButton;
    private Button qrCreatorButton;

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

    }

    private void launchQRScanner(){
        Intent intent = new Intent(this, QRScannerActivity.class);
        startActivity(intent);
    }

    private void launchQRCreator(){
        Intent intent = new Intent(this, ContentListActivity.class);
        startActivity(intent);
    }
}
