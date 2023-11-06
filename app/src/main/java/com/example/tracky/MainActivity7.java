package com.example.tracky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity7 extends AppCompatActivity {

    FirebaseAuth auth;
    TextView textView;
    Button button;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        ImageButton button8 = findViewById(R.id.button71);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity7.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        auth=FirebaseAuth.getInstance();
        button=findViewById(R.id.logout);
        textView=findViewById(R.id.main1);
        user= auth.getCurrentUser();
        if(user==null){
            Intent intent= new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(intent);
            finish();
        }
        else{
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
                finish();
            }
        });
    }
}