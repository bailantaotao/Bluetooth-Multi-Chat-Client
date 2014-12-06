package remoteControl.videoScope;

import android.util.Log;

/**
 * Created by edwinhsieh on 2014/8/28.
 */
public class videoScope {

    /** Log debug information */
    private static final String TAG  = videoScope.class.getSimpleName();

    /** determine whether or not enable debug message */
    public static final boolean D = true;

    public void Logd(String msg)
    {
        if(D)
            Log.d(TAG, "-----" + msg + "-----");
    }

    public void on()
    {
        Logd(" on ");
    }

    public void off()
    {
        Logd(" off ");
    }

    public void capture()
    {
        Logd(" capture ");
    }
}
