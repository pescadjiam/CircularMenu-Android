package circularmenu.pescadinha.com.circularmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by pescadjiam on 06-03-2016.
 */

public class CircularMenu implements View.OnClickListener {

    public interface IEventsListener{
        public void innerCircleClick();
    }

    private final String TAG = "CircularMenu";

    private RelativeLayout parent_layout, circular_parent_layout;
    private LinearLayout circular_inner_cirle;
    private TextView circular_inner_circle_text;

    private int DEFAULT_BACKGROUND_INNER_CIRCLE = Color.WHITE;
    private int DEFAULT_INNER_CIRCLE_TEXT_COLOR = Color.BLACK;

    private ViewGroup container;
    private Context context;

    private IEventsListener eventsListener;

    public CircularMenu(Context context, ViewGroup container, IEventsListener eventsListener){
        this.context = context;
        this.container = container;
        this.eventsListener = eventsListener;
        InitializeViews(context, container);
    }

    private void InitializeViews(Context context, ViewGroup container){
        View view = LayoutInflater.from(context).inflate(R.layout.circular_menu, container);

        //RELATIVE LAYOUTS
        parent_layout = (RelativeLayout) view.findViewById(R.id.parent_layout);
        circular_parent_layout = (RelativeLayout) view.findViewById(R.id.circular_parent_layout);

        //LINEAR LAYOUTS
        circular_inner_cirle = (LinearLayout) view.findViewById(R.id.circular_inner_circle);

        //TEXT VIEWS
        circular_inner_circle_text = (TextView) view.findViewById(R.id.circular_inner_circle_text);

        //DEFAULT VALUES
        setInnerCircleBackgroundColor(DEFAULT_BACKGROUND_INNER_CIRCLE);
        setInnerCircleTextColor(DEFAULT_INNER_CIRCLE_TEXT_COLOR);

        //CLICK LISTENER
        circular_inner_cirle.setOnClickListener(this);
    }

    //METHODS
    public String getInnerCircleText(){
        return circular_inner_circle_text.getText().toString();
    }

    public void setInnerCircleText(String text){
        circular_inner_circle_text.setText(text);
    }

    public void setInnerCircleBackgroundColor(int color){
        GradientDrawable gDrawable = (GradientDrawable) circular_inner_cirle.getBackground();
        gDrawable.setColor(color);
    }

    public void setInnerCircleTextColor(int color){
        circular_inner_circle_text.setTextColor(color);
    }

    public void setVisibility(int visibility){
        parent_layout.setVisibility(visibility);
    }

    public void blurBackground(boolean blur){
        Bitmap bg = Utilities.getBitmapFromView(container);
        bg = Utilities.getBlurredBitmap(context, bg, blur ? 25 : 0);
        container.setBackground(new BitmapDrawable(context.getResources(), bg));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == circular_inner_cirle.getId()){
            eventsListener.innerCircleClick();
        }
    }
}
