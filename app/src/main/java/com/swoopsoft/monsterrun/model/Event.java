package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class Event implements DataObject{

    private DatabaseReference eventRef;
    private DatabaseReference mDatabaseRef;

    public String eventid;
    public String name;
    public Date start_date;
    public Date end_date;

    public Event(String id, String name, Date start_date, Date end_date){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("leaderboards");
        eventRef = FirebaseDatabase.getInstance().getReference("leaderboards/"+eventid);
        eventid = eventRef.getKey();
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    @Override
    public void update(){
        eventRef = mDatabaseRef.push();
        eventRef.child("name").setValue(name);
        eventRef.child("start_date").setValue(start_date);
        eventRef.child("end_Date").setValue(end_date);
    }

    @Override
    public void sync(){
        //TODO: download server data

    }

}
