package com.swoopsoft.monsterrun;

import static android.hardware.Sensor.TYPE_STEP_COUNTER;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.swoopsoft.monsterrun.model.Leaderboard;
import com.swoopsoft.monsterrun.model.Player;

import java.util.ArrayList;
import java.util.HashMap;

import kotlin.math.UMathKt;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private final int FINISHED = 0;

    private ImageView easy, medium, hard, imageView9,imageView10,imageView11;
    private EditText email, pwd, confpwd, gender, nickname;
    private TextView eTitle, eDesc, mTitle, mDesc, hTitle, hDesc;
    private String difficulty;
    private FirebaseUser fUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //check if user already signed in
        fUser = FirebaseAuth.getInstance().getCurrentUser();
        if(fUser != null){
            moveToMain();
        }

        //bind user views
        email = findViewById(R.id.editTextEmail);
        pwd = findViewById(R.id.editTextTextPassword);
        confpwd = findViewById(R.id.editTextTextPassword2);
        gender = findViewById(R.id.editTextGender);
        nickname = findViewById(R.id.editTextTextPersonName2);
        easy = findViewById(R.id.imageView9);
        medium = findViewById(R.id.imageView10);
        hard = findViewById(R.id.imageView11);
        eTitle = findViewById(R.id.textView8);
        mTitle = findViewById(R.id.textView10);
        hTitle = findViewById(R.id.textView12);
        eDesc = findViewById(R.id.textView9);
        mDesc = findViewById(R.id.textView11);
        hDesc = findViewById(R.id.textView13);

        //create tap listeners
        easy.setOnClickListener(this);
        eTitle.setOnClickListener(this);
        eDesc.setOnClickListener(this);
        medium.setOnClickListener(this);
        mTitle.setOnClickListener(this);
        mDesc.setOnClickListener(this);
        hard.setOnClickListener(this);
        hTitle.setOnClickListener(this);
        hDesc.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //difficulty selection
        if(view == easy ||view == eTitle ||view == eDesc){

            if(emptyFields()){
                return;
            }

            difficulty = "easy";
            registerUser();

        }
        if(view == medium ||view == mTitle ||view == mDesc){

            if(emptyFields()){
                return;
            }

            difficulty = "medium";
            registerUser();

        }
        if(view == hard ||view == hTitle ||view == hDesc){

            if(emptyFields()){
                return;
            }

            difficulty = "hard";
            registerUser();
        }
    }

    //use when moving
    private void moveToMain() {
        setResult(FINISHED);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    private void registerUser() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getText().toString(),pwd.getText().toString())
            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    //create user object and add to database
                    fUser = FirebaseAuth.getInstance().getCurrentUser();
                    Player player = createPlayer();
                    DatabaseReference playersListRef = FirebaseDatabase.getInstance()
                            .getReference().child("players");
                    HashMap<String,Player> playerList =
                            (HashMap<String, Player>) DatabaseController
                                    .getObjectMap(playersListRef,Player.class);
                    if(playerList == null){
                        fUser.delete();
                        Toast.makeText(getApplicationContext(),"Failed to make user, try again later",Toast.LENGTH_LONG).show();
                        return;
                    }
                    playerList.put(fUser.getUid(), player);
                    DatabaseController.updateObject(playersListRef,playerList);
                    moveToMain();
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),"Failed to make user: " + e.getMessage(),Toast.LENGTH_LONG).show();
                    Log.d("RegisterActivity",e.getMessage());
                }
            });

    }

    private Player createPlayer() {
        HashMap statistics = new HashMap<String,Object>();
        statistics.put("difficulty",difficulty);
        statistics.put("gender",gender.getText().toString());
        return new Player(
                statistics,
                fUser.getEmail(),
                nickname.getText().toString(),
                0,
                new ArrayList<String>(),
                new HashMap<String,Integer>(),
                0
        );
    }

    private boolean emptyFields() {
        String message = getString(R.string.missing_register_fields);
        if(TextUtils.isEmpty(email.getText().toString())){
            message = message + getString(R.string.prompt_email) + " ";
        }
        if(TextUtils.isEmpty(pwd.getText().toString())){
            message = message + getString(R.string.prompt_password) + " ";
        }
        if(TextUtils.isEmpty(confpwd.getText().toString())){
            message = message + getString(R.string.prompt_conf_password) + " ";
        }
        if(TextUtils.isEmpty(gender.getText().toString())){
            message = message + getString(R.string.prompt_gender) + " ";
        }
        if(TextUtils.isEmpty(nickname.getText().toString())){
            message = message + getString(R.string.prompt_nickname);
        }

        if (!message.equals(getString(R.string.missing_register_fields))){
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            return true;
        }
        else{
            return false;
        }
    }
}
