package com.example.servicedemo;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StartService extends AppCompatActivity {

    public static final String TEXT = "make";
    public static final String NAME = "mak";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
    }

    public void onClickView(View view) {
        Intent intent = new Intent(this, ExamService.class);
        intent.putExtra(TEXT,"Make by Huy Nguyen");
        Intent intent1 = new Intent(this, ExamStartService.class);
        intent1.putExtra(NAME,"Make by SUN");
        int view1 = view.getId();
        if (view1 == R.id.button_StartService) {
            startService(intent);
            startService(intent1);
        }else {
            stopService(intent);
            stopService(intent1);
        }
    }
}
