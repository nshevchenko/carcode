package com.code.car.carcode.GUI;

import android.view.MotionEvent;
import android.view.View;

import com.code.car.carcode.Managers.AppManager;
import com.code.car.carcode.Managers.TouchManager;

/**
 * Created by Mykola Shevchenko on 16/02/2015.
 */
public class Clickable {

    protected int id;
    private View view;
    private boolean clickable;

    public Clickable (int id)
    {
        this.view = TouchManager.getActivity().findViewById(id) ;
        this.id = id;
        addListeners();
        addTouchListener();
    }

    public void setViewClickable(boolean clickable)
    {
        this.clickable = clickable;
    }


    public int getId()
    {
        return id;
    }

    public void addTouchListener()
    {
        if( ! clickable ) return;
        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // pointer goes down
                    onFocusUpdate(true);
                } else if (event.getAction() == MotionEvent.ACTION_HOVER_EXIT) {
                    // pointer goes up
                    onFocusUpdate(false);
                }
                return false;
            }
        });
    }

    public void addListeners()
    {
		/*if( !clickable || ButtonManager.currentScreenState == screenState.blocked)
		{
			System.out.println("blokced");
			return;
		}*/
        final Clickable click = this;
        view.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        //button.getBackground().setColorFilter(buttonColor, Mode.MULTIPLY);
                        switch(TouchManager.getActivityName())
                        {
                            case loadingScreen:
                                AppManager.mainScreen.onClick(click);
                                break;

                        }

                    }
                }
        );
    }


    public void onFocusUpdate(boolean onFocus)
    {
        /*
		if(buttonColor == 0 )
			return;
		if(onFocus)
			button.getBackground().setColorFilter(onFocusColor, Mode.MULTIPLY);
    	else
    		button.getBackground().setColorFilter(buttonColor, Mode.MULTIPLY);
    		*/
    }

}
