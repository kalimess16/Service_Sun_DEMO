package com.example.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class BothS_B extends AppCompatActivity {

    public static final String NAME = "make";
    BothExam mBothExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_s__b);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this,BothExam.class);
        intent.putExtra(NAME,"Huy nguyen");
        if (view.getId() == R.id.button_StarBoth){
            startService(intent);
            bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
        }else {
            stopService(intent);
            unbindService(mServiceConnection);
        }
    }

    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BothExam.ExemService service = (BothExam.ExemService) iBinder;
            mBothExam = service.getService();
            Toast.makeText(BothS_B.this, "Connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
