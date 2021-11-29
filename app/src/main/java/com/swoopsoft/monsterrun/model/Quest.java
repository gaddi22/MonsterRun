package com.swoopsoft.monsterrun.model;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.firebase.ui.*;
import com.google.firebase.database.Query;
public class Quest{

    public String objective;    //statistic name
    public ArrayList<String> reward; //Item ID

    public Quest(String objective, ArrayList<String> reward){
        this.objective = objective;
        this.reward = reward;
    }

    public Quest(){
        objective = "";
        reward = new ArrayList<String>();
    }

    public String getObjective() {
        return objective;
    }

    public ArrayList<String> getReward() {
        return reward;
    }
}
