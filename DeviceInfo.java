import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by pradyumnadoddala on 08/07/2013.
 */
 
public class DeviceInfo {
    public static String model = android.os.Build.MODEL;
    public static String device = android.os.Build.DEVICE;
    public static String brand = android.os.Build.BRAND;
    public static String manufacturer = android.os.Build.MANUFACTURER;
    public static String version = android.os.Build.VERSION.SDK_INT+"";
    public static String release = android.os.Build.VERSION.RELEASE;

    public static float resolution(Context context) {
        float scale;

        DisplayMetrics displaymetrics = new DisplayMetrics();

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displaymetrics);
        scale = context.getResources().getDisplayMetrics().density;

        return scale;
    }

    public static String dpi (Context context) {
        String density = "NONE";
        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                // ...
                density = "ldpi";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                // ...
                density = "mdpi";
                break;
            case DisplayMetrics.DENSITY_HIGH:
                // ...
                density = "hdpi";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                // ...
                density = "xhdpi";
                break;
//            case DisplayMetrics.DENSITY_XXHIGH:
//                density = "xxhdpi";
//                break;
        }
        return density;
    }

    public static String screen (Context context) {
        String screenLayout;
        //Determine screen size
        if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
              screenLayout = "large";
        }
        else if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            screenLayout = "normal";
        }
        else if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
            screenLayout = "small";
        }
        else {
            screenLayout = "Screen size is neither large, normal or small";
        }

        return screenLayout;
    }

    public static String screenSize(Context context) {
        int width,height;

        DisplayMetrics displaymetrics = new DisplayMetrics();

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displaymetrics);

        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        return width+" X "+height;
    }

    public static Point deviceSize(Context context) {
        int width,height;

        DisplayMetrics displaymetrics = new DisplayMetrics();

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displaymetrics);

        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        return new Point(width, height);
    }

    public static String operator(Context context) {
        TelephonyManager telephonyManager =((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE));
        String operatorName = telephonyManager.getNetworkOperatorName();

        String operatorNam = telephonyManager.getSimOperatorName();

        return operatorNam;
    }
}
