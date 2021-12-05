package com.swoopsoft.monsterrun;

import static android.hardware.Sensor.TYPE_STEP_COUNTER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.swoopsoft.monsterrun.model.Monster;
import com.swoopsoft.monsterrun.model.Player;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button leaderboard, logout, settings, inventory;
    private FirebaseUser user;
    private DatabaseReference userRef;
    private Player curPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }

        userRef = FirebaseDatabase.getInstance().getReference().child("users").child(user.getUid());
        curPlayer = (Player) DatabaseController.getObject(userRef, Player.class);

        leaderboard = findViewById(R.id.leaderboard_btn);
        logout = findViewById(R.id.log_out_btn);
        inventory = findViewById(R.id.inventory_btn);
        settings = findViewById(R.id.settings_button);

        settings.setOnClickListener(this);
        leaderboard.setOnClickListener(this);
        logout.setOnClickListener(this);
        inventory.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == leaderboard){
            startActivity(new Intent(getApplicationContext(),StatisticsActivity.class));
        }
        if(view == inventory){
            startActivity(new Intent(getApplicationContext(),InventoryActivity.class));
        }
        if(view == logout){
            FirebaseAuth.getInstance().signOut();

            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }
        if(view == settings){
            startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
        }
    }

    public static void changeMonster(Player player, DatabaseReference playerRef){
        /*assign random monster from database template monsters*/
        DatabaseReference monsterListRef = FirebaseDatabase.getInstance().getReference().child("monsters");
        ArrayList monsters = DatabaseController.getObjects(monsterListRef, Monster.class);

        //randomly choose monster
        Random rand = new Random();
        int monsterNum = rand.nextInt(monsters.size());
        player.monster = (Monster) monsters.get(monsterNum);

        DatabaseController.updateObject(playerRef,player);

    }

}