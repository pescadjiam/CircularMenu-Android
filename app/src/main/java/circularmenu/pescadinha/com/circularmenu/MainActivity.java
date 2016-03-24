package circularmenu.pescadinha.com.circularmenu;

import android.graphics.Bitmap;
import android.graphics.Color;
import  android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity{

    private final String TAG = "MainActivity";

    private RelativeLayout container;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        container = (RelativeLayout) findViewById(R.id.container);
        image = (ImageView) findViewById(R.id.imageView);

        CircularMenu circularMenu = new CircularMenu(this, container, new CircularMenu.IEventsListener() {
            @Override
            public void innerCircleClick() {
                Log.d(TAG, "InnerCircle Click");

            }
        });

        Bitmap bmp = Utilities.getBitmapFromView(container);
        image.setImageBitmap(bmp);

        circularMenu.blurBackground(true);
        circularMenu.setInnerCircleText("HELLO WORLD");
        circularMenu.setInnerCircleBackgroundColor(Color.WHITE);
        circularMenu.setInnerCircleTextColor(Color.BLACK);

    }
}
