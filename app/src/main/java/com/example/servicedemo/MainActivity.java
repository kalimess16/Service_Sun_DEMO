package com.example.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, StartService.class);
        Intent intentBound = new Intent(this, BoundService.class);
        Intent intentBoth = new Intent(this, BothS_B.class);
        switch (view.getId()) {
            case R.id.button_start:
                startActivity(intent);
                break;
            case R.id.button_Bound:
                startActivity(intentBound);
                break;
            default:
                startActivity(intentBoth);
                break;
        }
    }
}
