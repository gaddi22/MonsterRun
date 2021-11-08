package com.swoopsoft.monsterrun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.swoopsoft.monsterrun.model.Player;

import java.util.ArrayList;
import java.util.HashMap;

import kotlin.math.UMathKt;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView easy, medium, hard, imageView9,imageView10,imageView11;
    EditText email, pwd, confpwd, gender, nickname;
    TextView eTitle, eDesc, mTitle, mDesc, hTitle, hDesc;
    String difficulty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
        if(view == easy ||view == eTitle ||view == eDesc){

            if(emptyFields()){
                return;
            }

            difficulty = "easy";
            registerUser();

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        if(view == medium ||view == mTitle ||view == mDesc){

            if(emptyFields()){
                return;
            }

            difficulty = "medium";
            registerUser();

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        if(view == hard ||view == hTitle ||view == hDesc){

            if(emptyFields()){
                return;
            }

            difficulty = "hard";
            registerUser();

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }

    private void registerUser() {
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
