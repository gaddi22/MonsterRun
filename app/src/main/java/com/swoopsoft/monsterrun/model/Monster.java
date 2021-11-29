package com.swoopsoft.monsterrun.model;

import android.app.AlarmManager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Monster{

    public double distance;
    public String name;
    public long speed;  //steps per second
    public String icon; //URL to firebase storage
    public long persistence;    //time in miliseconds before monster gives up
    public double range;        //number of steps needed before
    public List<String> type;   //list of monster type Strings
    public List<String> reward_pool;    //possible reward itemIDs
    public long startTime;

    public Monster(){
        distance = 0;
        name = "";
        speed = 0;
        icon = "";
        persistence = 0;
        range = 0;
        type = new ArrayList<>();
        reward_pool = new ArrayList<>();
        startTime = System.currentTimeMillis();
    }

    public Monster( double distance, String name, long speed, String icon, long persistence, double range, List type, List reward_pool, long startTime){
        distance = 0;
        name = "";
        speed = 0;
        icon = "";
        persistence = 0;
        range = 0;
        type = new ArrayList<>();
        reward_pool = new ArrayList<>();
        startTime = System.currentTimeMillis();
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public long getSpeed() {
        return speed;
    }

    public String getIcon() {
        return icon;
    }

    public long getPersistence() {
        return persistence;
    }

    public double getRange() {
        return range;
    }

    public List<String> getType() {
        return type;
    }

    public List<String> getReward_pool() {
        return reward_pool;
    }

    public long getStartTime() {
        return startTime;
    }

    public boolean isTired(){
        if(startTime + persistence > System.currentTimeMillis()){
            return false;
        }
        else return true;
    }

    public boolean isLost(int playerSteps){

        if(stepDif(playerSteps)>range) return true;
        else return false;
    }

    public boolean caughtPlayer(int playerSteps){
        /*
            A positive step difference means the player is further than the monster
            Otherwise, the monster is at or past the player, meaning the player was caught
         */
        if(stepDif(playerSteps)>0) return false;
        else return true;
    }

    private double stepDif(int playerSteps){
        /*
            distance between palyer and monster in number of steps
         */

        //convert monster steps per second into steps per millisecond
        double milliSpeed = speed * Math.pow(10,-3);

        //calculate monster steps since start
        long timePassed = System.currentTimeMillis() - startTime;
        double monsterSteps = Math.floor(milliSpeed * timePassed);

        return playerSteps - monsterSteps;
    }

    public long getInterceptTime(int playerSteps){
        /*
            Time in millisceconds before monster catches player, assuming player is standing still
         */
        double stepDistance = stepDif(playerSteps);
        long millisToCoverDistance = (long)(stepDistance * speed * Math.pow(10,-3));
        return millisToCoverDistance;
    }
}
