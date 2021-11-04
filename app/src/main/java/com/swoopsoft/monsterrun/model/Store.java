package com.swoopsoft.monsterrun.model;

import android.provider.ContactsContract;

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
    private DatabaseReference mDatabaseRef;

    public String storeID;
    public List<Item> selling;    //Items for sale
    public Date start;      //Store opening date
    public Date end;        //Store close date

    public Store(String storeID, List selling, Date start, Date end){
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("stores");
        storeRef = FirebaseDatabase.getInstance().getReference("stores/"+storeID);
        storeID = storeRef.getKey();
        this.storeID = storeID;
        this.selling = selling;
        this.start =start;
        this.end = end;
    }

    @Override
    public void update() {

    }

    @Override
    public void sync() {

    }
}
