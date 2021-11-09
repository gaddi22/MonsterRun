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
public class Quest implements DataObject{
    private DatabaseReference questRef;
    private DatabaseReference mDatabaseRef;

    public String questid;
    public String objective;
    public String reward; //Item ID

    public Quest(String questid, String objective, String reward){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("quests");
        questRef = FirebaseDatabase.getInstance().getReference("quests/"+questid);
        questid = questRef.getKey();
        this.questid = questid;
        this.objective = objective;
        this.reward = reward;
    }

    @Override
    public void update() {

    }

    @Override
    public void sync() {

    }
}
