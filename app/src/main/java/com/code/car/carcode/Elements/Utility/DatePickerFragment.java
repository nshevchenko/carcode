package com.code.car.carcode.Elements.Utility;

/**
 * Created by nik on 21/02/15.
 */

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private Date pickedDate;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    public Date createDate (int year, int month, int day)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    public void onDateSet(DatePicker view, int year, int month, int day)
    {
        Date validDate = validateDate(createDate(year, month, day));
        String timeDiff = getTimeDifference(getStringDate(validDate));
        String dateString = dateFormat.format(validDate);

    }

    // STRING DATE FORMAT ALL OVER THE APP
    public static String strFormatDateHours = "yyyy-MM-dd hh:mm:ss";
    public static String strFormatDate = "dd-MM-yyyy";
    public static SimpleDateFormat dateHoursFormat = new SimpleDateFormat(strFormatDateHours);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat(strFormatDate);

    public static Date getTodayDate()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static String getTimeDifference(String dateStart)
    {
        String result = "";
        String today = dateHoursFormat.format(getTodayDate().getTime());

        Date d1 = null;
        Date d2 = null;
        try
        {
            d1 = dateHoursFormat.parse(dateStart);
            d2 = dateHoursFormat.parse(today);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

//			long diffMinutes = diff / (60 * 1000) % 60;
//			long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            if(diffDays == 0)
                result = "Today";
            else
            {
                if(diffDays == 1)
                    result = "Yesterday";
                else
                    result = diffDays + "d";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    // if in the future use today
    public static Date validateDate(Date date)
    {
        if(getTodayDate().getTime() - date.getTime() > 0)
            return date;
        return getTodayDate();
    }


    public static String getStringDate(Date date)
    {
        String dayPicked = dateHoursFormat.format(date.getTime());
        return dayPicked;
    }
}

