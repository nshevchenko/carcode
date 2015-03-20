package com.code.car.carcode.Managers;

import android.app.Activity;


import com.code.car.carcode.Elements.Utility.activityName;
import com.code.car.carcode.Elements.Utility.screenState;
import com.code.car.carcode.GUI.ButtonUI;
import com.code.car.carcode.GUI.Clickable;

import java.util.ArrayList;
/**
 * Created by Mykola Shevchenko on 16/02/2015.
 */
public class TouchManager {

    private static ArrayList<Clickable> buttons;
    private static Activity currentActivity;
    private static activityName currentActivityName;
    public static screenState currentScreenState;

    public static void init()
    {
        buttons = new ArrayList<Clickable>();
    }

    public static void initScreenActivity(Activity act, activityName actName)
    {
        currentActivity = act;
        currentActivityName = actName;
        currentScreenState = screenState.clickable;
    }


    public static void lockScreen()
    {
        currentScreenState = screenState.blocked;
    }

    public static void unlockScreen()
    {
        currentScreenState = screenState.clickable;
    }

    public static activityName getActivityName()
    {
        return currentActivityName;
    }

    public static Activity getActivity()
    {
        return currentActivity;
    }

    public static Clickable getButton(int resClickable)
    {
        for(Clickable clickable : buttons)
        {
            if(clickable.getId() == resClickable)
                return clickable;
        }
        return null;
    }

    public static ButtonUI createButton(int id)
    {
        ButtonUI buttonUI = new ButtonUI(true, id); // id used of reference to buttons on items of viewList. onClick -> id knows which button was pressed of the item. (id=0,1st item), id=2 3rd element
        System.out.println("hereee");
        System.out.println("id " + buttonUI.getId());
        System.out.println(buttons.size());
        buttons.add(buttonUI);
        return buttonUI;
    }

    public static void cleanScreenButtons(activityName actName)
    {
        ArrayList<Clickable> toRemove = new ArrayList<Clickable>();
        for(Clickable but : buttons)
        {
            toRemove.add(but);
        }
        for(Clickable clickable : toRemove)
            buttons.remove(clickable);

        toRemove.clear();
    }


}

