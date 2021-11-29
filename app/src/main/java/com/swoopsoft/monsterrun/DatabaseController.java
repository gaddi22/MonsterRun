package com.swoopsoft.monsterrun;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.swoopsoft.monsterrun.model.Monster;

import java.util.ArrayList;

public class DatabaseController {

    public static Object getObject(DatabaseReference objectRef, Class objectClass){

        Task<DataSnapshot> objectRequest = objectRef.get();

        while(!objectRequest.isComplete());
        if(objectRequest.isSuccessful()) return objectRequest.getResult().getValue(objectClass);
        else{
            objectRequest.getException().printStackTrace();
            Log.d("DatabaseController","Failed to get object: "+objectRequest.getException().getMessage());
            return null;
        }
    }

    public static ArrayList getObjects(DatabaseReference ref,Class listClass) {
        Task<DataSnapshot> objectsRequest = ref.get();
        ArrayList objects = new ArrayList();


        while(!objectsRequest.isComplete());
        if(objectsRequest.isSuccessful()){
            for(DataSnapshot child: objectsRequest.getResult().getChildren()){
                objects.add(child.getValue(listClass));
            }
            return objects;
        }
        else {
            objectsRequest.getException().printStackTrace();
            Log.d("DatabaseController","Failed to get object: "+objectsRequest.getException().getMessage());
            return null;
        }
    }

    public static void updateObject(DatabaseReference userRef, Object object) {

    }
}
