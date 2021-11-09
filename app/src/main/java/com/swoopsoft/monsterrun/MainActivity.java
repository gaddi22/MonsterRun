package com.swoopsoft.monsterrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button leaderboard, logout, time, inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leaderboard = findViewById(R.id.leaderboard_btn);
        logout = findViewById(R.id.log_out_btn);
        time = findViewById(R.id.time_remaining_btn);
        inventory = findViewById(R.id.inventory_btn);

        leaderboard.setOnClickListener(this);
        logout.setOnClickListener(this);
        time.setOnClickListener(this);
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
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }
        if(view == time){

        }
    }
}