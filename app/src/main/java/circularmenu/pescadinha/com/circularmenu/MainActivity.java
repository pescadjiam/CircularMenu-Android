package circularmenu.pescadinha.com.circularmenu;

import android.graphics.Color;
import  android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{

    private final String TAG = "MainActivity";

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        container = (LinearLayout) findViewById(R.id.container);


        CircularMenu circularMenu = new CircularMenu(this, container, new CircularMenu.IEventsListener() {
            @Override
            public void innerCircleClick() {
                Log.d(TAG, "InnerCircle Click");

            }
        });
        //circularMenu.blurBackground(true);
        circularMenu.setInnerCircleText("Hello");
        circularMenu.setInnerCircleBackgroundColor(Color.BLACK);
        circularMenu.setInnerCircleTextColor(Color.WHITE);

    }
}
