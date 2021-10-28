package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Leaderboard implements DataObject {
    private DatabaseReference leaderboardRef;
    private DatabaseReference mDatabaseRef;

    public Map<String, Object> rewards;
    public String leaderboardID;

    public Leaderboard(Map rewards){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("leaderboards");
        leaderboardRef = FirebaseDatabase.getInstance().getReference("leaderboards/"+leaderboardID);
        this.rewards=rewards;
        leaderboardID = leaderboardRef.getKey();
    }

    @Override
    public void update(){
        leaderboardRef = mDatabaseRef.push();
        leaderboardRef.child("rewards").setValue(rewards);
        leaderboardRef.child("leaderboardID").setValue(leaderboardID);
    }

    @Override
    public void sync(){
        //TODO: download server data

    }
}
