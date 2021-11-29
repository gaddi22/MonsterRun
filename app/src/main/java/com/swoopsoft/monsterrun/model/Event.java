package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Event{

    public String name;
    public long start_date; //time in milliseconds
    public long end_date;   //time in milliseconds
    public List<String> quests;
    public List<String> leaderboards;
    public List<String> multipliers;

    public Event(){
        name = "";
        start_date = 0;
        end_date = 0;
        quests = new ArrayList<>();
        leaderboards = new ArrayList<>();
        multipliers = new ArrayList<>();
    }

    public Event(String name, long start_date, long end_date, List<String> quests, List<String> leaderboards, List<String> multipliers ){
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.quests = quests;
        this.leaderboards = leaderboards;
        this.multipliers = multipliers;
    }

    public String getName(){
        return name;
    }

    public long getStart_date() {
        return start_date;
    }

    public long getEnd_date() {
        return end_date;
    }

    public List<String> getLeaderboards() {
        return leaderboards;
    }

    public List<String> getMultipliers() {
        return multipliers;
    }

    public List<String> getQuests() {
        return quests;
    }
}
