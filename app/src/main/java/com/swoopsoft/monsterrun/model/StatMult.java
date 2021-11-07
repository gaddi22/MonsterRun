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
public class StatMult implements DataObject{
    private DatabaseReference statRef;
    private DatabaseReference mDatabaseRef;

    public String multiplierid;
    public double multiplier;
    public String statistic; //Stat ID

    public StatMult(String multiplierid, double multiplier, String statistic){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("stats_multiplier");
        statRef = FirebaseDatabase.getInstance().getReference("stats_multiplier/"+multiplierid);
        multiplierid = statRef.getKey();
        this.multiplierid = multiplierid;
        this.multiplier = multiplier;
        this.statistic = statistic;
    }

    @Override
    public void update() {

    }

    @Override
    public void sync() {

    }
}
