package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Monster implements DataObject{

    public  int distance;
    private DatabaseReference monsterRef;
    private DatabaseReference mDatabaseRef;

    public String monsterID;
    public String name;
    public String speed;
    public String icon;
    public String persistence;
    public String range;
    public String type;
    public String reward_pool;

    public Monster(String id, String name, String speed, String icon, String persistence, String range, String type, String reward_pool){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("monsters");
        monsterRef = FirebaseDatabase.getInstance().getReference("monsters/"+monsterID);
        monsterID = monsterRef.getKey();
        this.name = name;
        this.speed = speed;
        this.icon = icon;
        this.persistence = persistence;
        this. range = range;
        this. type = type;
        this. reward_pool = reward_pool;
    }

    @Override
    public void update(){

    }

    @Override
    public void sync(){


    }

}
