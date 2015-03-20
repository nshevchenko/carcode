package com.code.car.carcode.Elements;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.code.car.carcode.AutoCompletionGeo.SearchPlacesTask;
import com.code.car.carcode.Managers.AppManager;

import java.util.ArrayList;

/**
 * Created by nik on 21/02/15.
 */
public class AutoCompleteSearch {

    private AutoCompleteTextView editView;

    public AutoCompleteSearch(AutoCompleteTextView view)
    {
        editView = view;
        addListenerEditText();
        addListenerClick();
    }

    public AutoCompleteTextView getEditView()
    {
        return editView;
    }

    private void addListenerEditText()
    {
        System.out.println("add listerner edit text");
        if(editView == null)
            return;

        final AutoCompleteSearch _this = this;
        editView.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                System.out.println("changed text" + s.toString());
                SearchPlacesTask completionTask = new SearchPlacesTask(_this);
                completionTask.execute(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        editView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    updateAdapterCompletionText(AppManager.dataManager.getLastSearched());
            }
        });
    }

    private void addListenerClick()
    {
        editView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Place place = (Place) editView.getAdapter().getItem(position);
                System.out.println("clicked on the item with name : " + place.street);
                editView.setText(place.street);
                editView.setSelected(false);
                //AppManager.searchScreen.clickedOnAutoCompleteItem(position, place);
            }
        });
    }

    public void updateAdapterCompletionText(ArrayList<Place> places)
    {
//        ListPlacesAutoCompletionAdapter adapter = new ListPlacesAutoCompletionAdapter(TouchManager.getActivity(), R.layout.simple_list_item, places);
//        editView.setAdapter(adapter);
//        //googleMap.cameraUpdatePos(loc);
//        editView.showDropDown();
    }
}

