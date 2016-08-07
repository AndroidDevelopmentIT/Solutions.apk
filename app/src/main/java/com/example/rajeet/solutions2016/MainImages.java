package com.example.rajeet.solutions2016;

import android.content.SharedPreferences;

/**
 * Created by NIKHIL SANJAY WAGH on 01-08-2016.
 */

public class MainImages {

    private String eventName;
    private String name;
    private String college;
    private String email;
    private String phone;

    public MainImages( String eventName,String name, String college, String email,String phone)
    {
        this.eventName = eventName;
        this.name = name;
        this.college = college;
        this.email = email;
        this.phone = phone;
    }

    public String getEventName()
    {
        return eventName;
    }
    public String getName(){ return name; }
    public String getCollege(){ return college; }
    public String getEmail(){ return email; }
    public String getPhone(){ return phone; }

}
