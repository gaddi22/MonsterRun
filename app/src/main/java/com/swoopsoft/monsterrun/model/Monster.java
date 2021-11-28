package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Monster implements DataObject{

    public  int distance;
    private DatabaseReference monsterRef;
    private DatabaseReference mDatabaseRef;

    public String monsterID;
    public String name;
    public long speed;
    public String icon;
    public double persistence;
    public double range;
    public String type;
    public Item reward;
    public date startTime;

    public String Monster(String id, String name, long speed, String icon, double persistence, double range, String type, Item reward, date startTime){
        this.startTime = startTime;
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("monsters");
        monsterRef = FirebaseDatabase.getInstance().getReference("monsters/"+monsterID);
        monsterID = monsterRef.getKey();
        this.name = name;
        this.speed = speed;
        this.icon = icon;
        this.persistence = persistence;
        this. range = range;
        this. type = type;
        this. Item = reward;
        this. date = startTime;

     public String getName(){
         return name;
     }

    public long getSpeed(){
         return speed;
    }

    public String getIcon(){
         return icon;
        }

    public double getPersistence(){
         return persistence;
        }

     public double getRange(){
         return range;
        }

     public String getType(){
         return type;
        }

    public Item getReward(){
            return reward;
        }

    public Date getStartTime(){
         return startTime;
        }




    @Override
    public void update(){

    }

    @Override
    public void sync(){


    }

}
