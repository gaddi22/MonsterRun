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
public class Store implements DataObject{
    private DatabaseReference storeRef;

    public String storeID;

    public Store(String storeID){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("stores");
        StoreRef = FirebaseDatabase.getInstance().getReference("stores/"+storeID);
        storeID = storeRef.getKey();
        this.storeID = storeID;
    }

    @Override
    public void update() {

    }

    @Override
    public void sync() {

    }
}
