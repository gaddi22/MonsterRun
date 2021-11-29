package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Item{

    public String name;
    public List<String> abilities;   //Abilities list
    public long value;    //Currency value

    public Item(){
        name = "";
        abilities = new ArrayList();
        value = 0;
    }

    public Item(String name, List abilities, long value){
        this.name = name;
        this.abilities = abilities;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public List getAbilities() {
        return abilities;
    }
}

