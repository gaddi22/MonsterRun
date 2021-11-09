package com.swoopsoft.monsterrun.model;

import android.util.Log;

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
import java.util.function.BiConsumer;

import com.firebase.ui.*;
import com.google.firebase.database.Query;
import com.google.firebase.database.core.SnapshotHolder;

public class Player implements DataObject{
    private DatabaseReference userRef;

    public Map<String, Object> statistics;  //{statName, value}
    public String id;
    public String email;
    public String username;
    public double money;
    private DatabaseReference progressRef;
    public Monster monster;
    public HashMap<Item,Integer> inventory;   //{Item, Amount}

    public List<Leaderboard> leaderboards;

    public Player(HashMap statistics, String id, String email, String username, double money, List<Leaderboard> leaderboards){
        userRef = FirebaseDatabase.getInstance().getReference("players/"+id);

        this.statistics=statistics;
        this.id=id;
        this.email=email;
        this.username=username;
        this.money=money;
        this.leaderboards = leaderboards;
        inventory = new HashMap();
    }

    /*Update and Sync Methods*/

    //updates server to match local
    @Override
    public void update(){
        Log.d("Player","Updating user with values: "
                + "\nstatistics: " + statistics + " "
                + "\nemail: " + email + " "
                + "\nusername: " + username + " "
                + "\nmoney: " + money + " "
                + "\nalong with inventory and leaderboards");

        userRef.child("statistics").setValue(statistics);
        userRef.child("email").setValue(email);
        userRef.child("username").setValue(username);
        userRef.child("money").setValue(money);

        //save each leaderboard as an id
        for(Leaderboard leaderboard: this.leaderboards){
            userRef.child("leaderboards").setValue(leaderboard.leaderboardID);
        }

        //saveItem MapAction
        BiConsumer<Item,Integer> saveItem = (item,amount) ->
        {
            userRef.child("inventory").setValue(item.name);
            userRef.child("inventory").child(item.name).setValue(amount);
        };
        inventory.forEach(saveItem);

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

