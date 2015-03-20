package com.code.car.carcode.Elements;

import java.util.ArrayList;

/**
 * Created by Mykola Shevchenko on 17/02/2015.
 */
public class User {

    private String name;
    private int id;
    ArrayList<User> friends;

    public User(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public void addFriend(User friend)
    {
        friends.add(friend);
    }

    public void removeFriend(User friend)
    {
        friends.remove(friend);
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }
}
