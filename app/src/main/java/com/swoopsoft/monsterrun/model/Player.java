package com.swoopsoft.monsterrun.model;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.firebase.ui.*;
import com.google.firebase.database.Query;

public class Player implements DataObject{
    private DatabaseReference userRef;

    public Map<String, Object> statistics;
    public String id;
    public String email;
    public String username;
    public double money;
    private DatabaseReference progressRef;

    public List<Leaderboard> leaderboards;

    public Player(HashMap statistics, String id, String email, String username, double money, List<Leaderboard> leaderboards){
        userRef = FirebaseDatabase.getInstance().getReference("players/"+id);

        this.statistics=statistics;
        this.id=id;
        this.email=email;
        this.username=username;
        this.money=money;
        this.leaderboards = leaderboards;
    }

    /*Update and Sync Methods*/
    @Override
    public void update(){
        userRef.child("statistics").setValue(statistics);
        userRef.child("id").setValue(id);
        userRef.child("email").setValue(email);
        userRef.child("username").setValue(username);
        userRef.child("money").setValue(money);
        userRef.child("leaderboards").setValue(leaderboards);

    }

    @Override
    //updates this class with values from the database
    public void sync(){
        Query queryRef = userRef.orderByChild("id").equalTo(id).limitToFirst(1);
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Player>()
                .setQuery(queryRef, new SnapshotParser<Player>(){
                    @NonNull
                    @Override
                    public Player parseSnapshot(@NonNull DataSnapshot snapshot) {
                        return new Player((HashMap)snapshot.child("statistics").getValue(),
                                snapshot.child("id").getValue().toString(),
                                snapshot.child("email").getValue().toString(),
                                snapshot.child("username").getValue().toString(),
                                (double)snapshot.child("money").getValue(),
                                (List)snapshot.child("leaderboards").getValue());
                    }
                })
                .build();

        this.statistics = ((Player) options.getSnapshots().get(0)).statistics;
        this.id = ((Player) options.getSnapshots().get(0)).id;
        this.email = ((Player) options.getSnapshots().get(0)).email;
        this.username = ((Player) options.getSnapshots().get(0)).username;
        this.money = ((Player) options.getSnapshots().get(0)).money;
        this.leaderboards = ((Player) options.getSnapshots().get(0)).leaderboards;

    }
}

