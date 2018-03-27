package fourloops.scavenger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton qrLaunchButton;
    private ImageButton qrCreatorButton;
    private ImageButton pinButton;
    private Rect bounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrLaunchButton = findViewById(R.id.obj_qr_scanner);
        CameraTouchListener camTouchListener = new CameraTouchListener();
        qrLaunchButton.setOnTouchListener(camTouchListener);

        qrCreatorButton = findViewById(R.id.create_new_qr);
        NewQRTouchListener newQRTouchListener = new NewQRTouchListener();
        qrCreatorButton.setOnTouchListener(newQRTouchListener);

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

    private class CameraTouchListener implements View.OnTouchListener {
        private boolean canPress = true;
        public boolean onTouch(View view, MotionEvent event) {
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    qrLaunchButton.setImageResource(R.drawable.ic_camera_button_pressed);
                    bounds = new Rect(view.getLeft(), view.getTop(), view.getRight(),view.getBottom());
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.d("Button","Should cancel action");
                    if(!bounds.contains(view.getLeft() + (int) event.getX(),view.getTop() + (int) event.getY())){
                        qrLaunchButton.setImageResource(R.drawable.ic_camera_button);
                        canPress = false;
                    }
                    else{
                        qrLaunchButton.setImageResource(R.drawable.ic_camera_button_pressed);
                        canPress = true;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if(canPress){
                        qrLaunchButton.setImageResource(R.drawable.ic_camera_button);
                        view.performClick();
                        launchQRScanner();
                    }
                    else {
                        canPress = true;
                    }
                    break;
                default:
                    break;
            }
            return true;
        }
    }

    private class NewQRTouchListener implements View.OnTouchListener {
        private boolean canPress = true;
        public boolean onTouch(View view, MotionEvent event) {
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    qrCreatorButton.setImageResource(R.drawable.ic_new_qr_pressed);
                    bounds = new Rect(view.getLeft(), view.getTop(), view.getRight(),view.getBottom());
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.d("Button","Should cancel action");
                    if(!bounds.contains(view.getLeft() + (int) event.getX(),view.getTop() + (int) event.getY())){
                        qrCreatorButton.setImageResource(R.drawable.ic_new_qr_button);
                        canPress = false;
                    }
                    else{
                        qrCreatorButton.setImageResource(R.drawable.ic_new_qr_pressed);
                        canPress = true;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if(canPress){
                        qrCreatorButton.setImageResource(R.drawable.ic_new_qr_button);
//                        view.performClick();
//                        launchQRScanner();
                    }
                    else {
                        canPress = true;
                    }
                    break;
                default:
                    break;
            }
            return true;
        }
    }
}
