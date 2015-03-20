package com.code.car.carcode.Managers;

import com.code.car.carcode.Elements.Place;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/**
 * Created by Mykola Shevchenko on 17/02/2015.
 */
public class DataManager {


//    private static ArrayList<Match> matches;
    private static ArrayList<Place> lastSearched;


    public DataManager()
    {
        testData();
    }

    public static void testData()
    {
        //public Match(User host, ArrayList<User> players, int location, Date date, String tim, pitchType pitchType)
//        matches = new ArrayList<Match>();
//        ArrayList<User> users = new ArrayList<User>();
//        User host = new User("Mykola S.",0);
//        User host2 = new User("Henrik S.",0);
//        users.add(new User("Test User1", 1));
//        users.add(new User("Test User2", 2));
//        users.add(new User("Test User3", 3));
//        users.add(new User("Test User4", 4));
//        LatLng testLat = new LatLng(42,2);
//        Match test1 = new Match(host, 10, users, testLat, 1, "", pitchType.astro);
//        Match test2 = new Match(host, 22, users, testLat, 1, "", pitchType.grass);
//        Match test3 = new Match(host2, 12, users, testLat, 1, "", pitchType.gym);
//        matches.add(test1);
//        matches.add(test2);
//        matches.add(test3);
//        matches.add(test1);
//        matches.add(test2);
//        matches.add(test3);
//        lastSearched = new ArrayList<Place>();
//        lastSearched.add(new Place(null, "Mile end, E3 London UK"));
//        lastSearched.add(new Place(null, "Stratford, London UK"));
//        lastSearched.add(new Place(null, "Poplar3, London UK"));
    }

//    public static ArrayList<Match> getMatchesList()
//    {
//        return matches;
//    }
//
    public static ArrayList<Place> getLastSearched()
    {
        return lastSearched;
    }
}
