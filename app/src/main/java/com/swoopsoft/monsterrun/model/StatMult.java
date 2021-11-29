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
public class StatMult{

    public double multiplier;
    public String statistic; //Stat ID

    public StatMult(double multiplier, String statistic){
        this.multiplier = multiplier;
        this.statistic = statistic;
    }

    public StatMult(){
        multiplier = 1;
        statistic = "";
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getStatistic() {
        return statistic;
    }
}
