package com.code.car.carcode.GUI;


import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.code.car.carcode.Managers.TouchManager;


public class ButtonUI extends Clickable{
	
	private Button button;
	private int color;

	public Button getButton()
    {
        return button;
	}

	public void changeColor(int newColor)
	{
		button.getBackground().setColorFilter(newColor, Mode.MULTIPLY);
		//buttonColor = newColor;
	}

    public ButtonUI(boolean clickable, int id)
	{
        super(id);
        button = (Button) TouchManager.getActivity().findViewById(id);
        System.out.println(button.getId());
	}




}
