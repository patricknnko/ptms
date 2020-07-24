package com.example.ptms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    EditText reg_name,reg_username,reg_email,reg_phoneNo,reg_password,reg_repassword;
    Button reg_login_btn,reg_btn;
    DatabaseReference reference;
    users yusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        //text
        reg_name=findViewById(R.id.reg_name);
        reg_username=findViewById(R.id.reg_username);
        reg_email=findViewById(R.id.reg_email);
        reg_phoneNo=findViewById(R.id.reg_phoneNo);
        reg_password=findViewById(R.id.reg_password);
        reg_repassword=findViewById(R.id.reg_repassword);

        //database
        reference= FirebaseDatabase.getInstance().getReference().child("users");

        //button
        reg_btn=findViewById(R.id.reg_btn);
        yusers=new users();
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                yusers.setName(reg_name.getText().toString().trim());
                yusers.setName(reg_username.getText().toString().trim());
                yusers.setName(reg_email.getText().toString().trim());
                yusers.setName(reg_password.getText().toString().trim());
                yusers.setName(reg_repassword.getText().toString().trim());
                yusers.setName(reg_phoneNo.getText().toString().trim());
                reference.push().setValue(yusers);
                Toast.makeText(Signup.this,"umefanikiwa kuingiza data",Toast.LENGTH_LONG).show();

            }
        });

        reg_login_btn=findViewById(R.id.reg_login_btn);
        reg_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
