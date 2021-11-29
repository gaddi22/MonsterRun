package com.swoopsoft.monsterrun.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Leaderboard {
    public Map<Integer, String> rewards; //Bracket number, rewardID
    public String statsistic;
    public Map<String,Double> progress ; //PlayerID, Progress Amount

    public Leaderboard(){
        rewards = new HashMap<>();
        statsistic = "";
        progress = new HashMap<>();
    }

    public Leaderboard(Map rewards, String statsistic){
        this.rewards=rewards;
        this.statsistic = statsistic;
        HashMap progress = new HashMap();
    }

    public String getStatsistic() {
        return statsistic;
    }

    public Map<Integer, String> getRewards() {
        return rewards;
    }

    public Map<String, Double> getProgress() {
        return progress;
    }

    public double getSpecificProgress(String playerID){
        return progress.get(playerID);
    }
}
