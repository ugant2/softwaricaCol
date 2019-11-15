package com.yograj.esoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button login;
    String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=username.getText().toString().trim();
                pass=password.getText().toString().trim();
                if(!user.isEmpty()&& !pass.isEmpty()){

                    if(user.equals("admin")&&pass.equals("admin")){
                        Intent intent= new Intent(LoginActivity.this,DashboardActivity.class);
                        startActivity(intent);
                        //Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    if(user.isEmpty()){
                        username.setError("Enter Username");
                    }
                    if(pass.isEmpty()){
                        username.setError("Enter Password");
                    }
                }
            }
        });
    }
}
