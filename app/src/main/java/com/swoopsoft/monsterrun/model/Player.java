package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Player {
    private DatabaseReference userRef;

    public HashMap<String, Object> statistics;
    public String id;
    public String email;
    public String username;
    public double money;

    public Player(HashMap statistics, String id, String email, String username, double money){
        userRef = FirebaseDatabase.getInstance().getReference("players/"+id);
        this.statistics=statistics;
        this.id=id;
        this.email=email;
        this.username=username;
        this.money=money;
    }

    /*Update and Sync Methods*/
    public void update(){
        userRef.child("statistics").setValue(statistics);
        userRef.child("id").setValue(id);
        userRef.child("email").setValue(email);
        userRef.child("username").setValue(username);
        userRef.child("money").setValue(money);

    }
}

