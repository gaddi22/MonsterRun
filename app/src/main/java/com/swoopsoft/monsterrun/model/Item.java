package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Item implements DataObject{

    private DatabaseReference itemRef;
    private DatabaseReference mDatabaseRef;

    public String item;
    public String name;
    public String abilities;
    public String value;

    public Item(String name, String abilities, String value){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("items");
        itemRef = FirebaseDatabase.getInstance().getReference("items/"+item);
        item = itemRef.getKey();
        this.name = name;
        this.abilities = abilities;
        this.value = value;
    }


    @Override
    public void update() {

    }

    @Override
    public void sync() {

    }
}

