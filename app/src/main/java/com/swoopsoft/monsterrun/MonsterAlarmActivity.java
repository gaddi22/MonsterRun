package com.swoopsoft.monsterrun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.swoopsoft.monsterrun.exceptions.MonsterAlarmException;
import com.swoopsoft.monsterrun.model.Monster;
import com.swoopsoft.monsterrun.model.Player;

public class MonsterAlarmActivity extends AppCompatActivity {

    private final String TAG = "MonsterAlarmActivity";
    private long lastAlarmTime;
    private Player player;
    private Monster monster;
    private DatabaseReference playerRef;
    private DatabaseReference monsterRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            if (getIntent().getExtras().isEmpty()) {
                throw new MonsterAlarmException();
            }
        }
        catch (MonsterAlarmException e){
            Log.d(TAG,e.getMessage());
            e.printStackTrace();
        }

        monsterRef = FirebaseDatabase.getInstance().getReference(getIntent().getExtras().getString("monster"));
        monster = (Monster) DatabaseController.getObject(monsterRef,Monster.class);

        playerRef = FirebaseDatabase.getInstance().getReference(getIntent().getExtras().getString("player"));
        player = (Player) DatabaseController.getObject(playerRef,Player.class);

        createCatchAlarm(monster , getIntent().getExtras().getInt("playerSteps"));
        createEscapeAlarm(monster, getIntent().getExtras().getInt("playerSteps"));
    }

    private void createEscapeAlarm(Monster monster, int playerSteps) {

    }

    private void createCatchAlarm(Monster m,int playerSteps) {
        //check if player is caught, ends this timer
        if(m.caughtPlayer(playerSteps)){
            MainActivity.changeMonster(player, playerRef);
            finish();
        }

        long catchTime = m.getInterceptTime(playerSteps);

        //if last alarm was less than five minutes ago
        if(lastAlarmTime<(System.currentTimeMillis()-(60000 * 5))){
            //make
            createEscapeAlarm(m,playerSteps);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            long fiveMinutesInMillies = 60000 * 5;

            Intent alarmIntent = new Intent();
            alarmIntent.putExtra("monster",monsterRef.toString());
            alarmIntent.putExtra("player", playerRef.toString());
            //alarmManager.setExact(AlarmManager.RTC_WAKEUP,fiveMinutesInMillies, PendingIntent.getActivity(getApplicationContext(),2,));

        }
        else{

        }


    }
}