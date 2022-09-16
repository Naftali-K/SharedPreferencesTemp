package com.nk.sharedpreferencestemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEt, emailEt;
    private Button saveBtn, loadBtn;
    private TextView userNameTv, emailTv;

    private String userName, email;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setReferences();

        sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = userNameEt.getText().toString();
                email = emailEt.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("userName", userName);
                editor.putString("email", email);
                editor.commit();

                Toast.makeText(MainActivity.this, "Information Saved", Toast.LENGTH_SHORT).show();
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = sharedPreferences.getString("userName", "null");
                email = sharedPreferences.getString("email", "null");

                userNameTv.setText(userName);
                emailTv.setText(email);
            }
        });
    }

    private void setReferences(){
        userNameEt = findViewById(R.id.user_name_et);
        emailEt = findViewById(R.id.email_et);
        saveBtn = findViewById(R.id.save_btn);
        loadBtn = findViewById(R.id.load_btn);
        userNameTv = findViewById(R.id.user_name_tv);
        emailTv = findViewById(R.id.email_tv);
    }
}