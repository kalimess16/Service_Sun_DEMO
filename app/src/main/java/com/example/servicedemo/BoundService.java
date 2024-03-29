package com.example.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BoundService extends AppCompatActivity {

    ExamBoundService mExamBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);
    }

    public void onClickView(View view) {
        Intent intent = new Intent(this,ExamBoundService.class);
        if (view.getId() == R.id.button_StartBoundService){
            bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
        }
    }

    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ExamBoundService.DemoBoundService demoBoundService =
                    (ExamBoundService.DemoBoundService) iBinder;
            mExamBoundService = demoBoundService.getService();
            Toast.makeText(BoundService.this, "Connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Toast.makeText(BoundService.this, "Connect", Toast.LENGTH_SHORT).show();
        }
    };
}
