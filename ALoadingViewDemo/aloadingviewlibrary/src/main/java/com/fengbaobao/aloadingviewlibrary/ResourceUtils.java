package com.fengbaobao.aloadingviewlibrary;

import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by dreamtang860 on 3/1/16.
 */
public class ResourceUtils {

    public static boolean checkResourceID(String resIDName) {

        Field mField = null;

        try {
            mField = R.id.class.getField(resIDName);
        } catch (Exception e) {
            Log.e("lk_test", "checkResourceID[" + resIDName + "] = " + (null != mField));
            return false;
        } catch (Throwable t) {
            Log.e("lk_test", "checkResourceID[" + resIDName + "] = " + (null != mField));
            return false;
        }

        Log.e("lk_test", "checkResourceID[" + resIDName + "] = " + (null != mField));
        return null != mField;
    }

    public static boolean checkResourceAnim(String animName) {

        Field mField = null;

        try {
            mField = R.anim.class.getField(animName);
        } catch (Exception e) {
            return false;
        } catch (Throwable t) {
            return false;
        }

        return null != mField;
    }

}

