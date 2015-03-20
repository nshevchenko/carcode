package com.code.car.carcode.Elements;

import android.location.Address;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Mykola Shevchenko on 20/02/2015.
 */
public class Place {
    public LatLng latlng;
    public String street;
    public String addressDetail; // town, country

    public Place(LatLng latLng, String address)
    {
        this.latlng = latLng;
        String[] splitStr = address.split(",", 2);
        street = splitStr[0];
        addressDetail = splitStr[1];
        System.out.println(street + " " + addressDetail);
    }
}
