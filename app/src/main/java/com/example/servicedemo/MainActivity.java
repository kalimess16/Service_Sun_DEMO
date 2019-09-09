package com.example.servicedemo;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this,ExamService.class);
        if (view.getId() == R.id.button_start) {
            startService(intent);
        } else {
            Toast.makeText(this, "Bound", Toast.LENGTH_SHORT).show();
        }
    }
}
