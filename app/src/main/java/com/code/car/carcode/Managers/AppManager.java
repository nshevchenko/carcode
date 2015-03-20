package com.code.car.carcode.Managers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;

import com.code.car.carcode.MainScreen;

/**
 * Created by Mykola Shevchenko on 16/02/2015.
 */
public class AppManager {

    // Screens
    public static MainScreen mainScreen;

    // Internal App Managers
    public static LocationManager locationManager;
    public static DataManager dataManager;

    public static String[] tabs = {"Home", "Join", "Host"};

    public static void initApp()
    {
        TouchManager.init();
        dataManager = new DataManager();
    }


    public static void initLocManager()
    {
        locationManager = (LocationManager)TouchManager.getActivity().getSystemService(Context.LOCATION_SERVICE);
    }

    public static void openScreen(Activity activity, Class newScreen)
    {
        Intent intent = new Intent(activity, newScreen);
        activity.startActivity(intent);
    }
}
