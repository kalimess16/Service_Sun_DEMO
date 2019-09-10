package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class BothExam extends Service {

    public final IBinder mIBinder = new ExemService();

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Create both is Called", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String name = null;
        if (intent!=null){
            name = intent.getStringExtra(BothS_B.NAME);
        }
        Toast.makeText(this, "onnBind is called: "+ name, Toast.LENGTH_SHORT).show();
        return mIBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name = null;
        if (intent!=null){
            name = intent.getStringExtra(BothS_B.NAME);
        }
        Toast.makeText(this, "Start command is called: by "+name, Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Toast.makeText(this, "unBind Return true", Toast.LENGTH_SHORT).show();
    }

    public class ExemService extends Binder{
        BothExam getService(){
            return BothExam.this;
        }
    }
}
