package circularmenu.pescadinha.com.circularmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.ViewGroup;

import java.lang.annotation.ElementType;

/**
 * Created by pescadjiam on 06-03-2016.
 */

public class Utilities {

    public static Bitmap getBitmapFromView(ViewGroup view){
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static Bitmap getBlurredBitmap(Context context, Bitmap originalBitmap, int radius){
        Bitmap blurredBitmap;
        blurredBitmap = Bitmap.createBitmap(originalBitmap);

        RenderScript rs = RenderScript.create(context);

        Allocation input = Allocation.createFromBitmap(rs,
                originalBitmap,
                Allocation.MipmapControl.MIPMAP_FULL,
                Allocation.USAGE_SCRIPT);

        Allocation output = Allocation.createTyped(rs, input.getType());

        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setInput(input);

        script.setRadius(radius);

        script.forEach(output);

        output.copyTo(blurredBitmap);

        return blurredBitmap;



    }
}
