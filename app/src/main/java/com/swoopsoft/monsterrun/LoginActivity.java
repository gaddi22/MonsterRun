package com.swoopsoft.monsterrun;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "LoginActivity";

    EditText email, pswd;
    TextView registerTxt;
    Button loginBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        //check if user already logged in
        if(user != null){
            Intent i = new Intent(getApplicationContext() ,MainActivity.class);
            startActivity(i);
            finish();
        }

        email = findViewById(R.id.editTextTextEmailAddress2);
        pswd = findViewById(R.id.editTextTextPassword3);
        registerTxt = findViewById(R.id.register_link);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(this);
        registerTxt.setOnClickListener(this);

    }

    private void userLogin() {
        String email = this.email.getText().toString();
        String password = pswd.getText().toString();

        //check for empty fields
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_LONG);
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_LONG);
            return;
        }

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "signInWithEmail:success");
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                        else{
                            //failed login
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    @Override
    public void onClick(View view) {
        if(view == registerTxt){
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            //TODO: get result of register activity and finish this actiivity if register activity is done
            /*
            ActivityResultLauncher<String> getContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {

                }
            });


             */
        }
        if(view == loginBtn){
            userLogin();

        }
    }
}