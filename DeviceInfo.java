import android.content.Context;
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

    public static String operator(Context context) {
        TelephonyManager telephonyManager =((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE));
        String operatorName = telephonyManager.getNetworkOperatorName();

        String operatorNam = telephonyManager.getSimOperatorName();

        return operatorNam;
    }
}
