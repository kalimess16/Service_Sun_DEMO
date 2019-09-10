package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class ExamStartService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    // khởi tạo 1 lần và ko khởi tạo lại lần nữa, y như thằng onCreate() bên activity
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate Start Service is called: ", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String text = null;
        if (intent != null) {
            text = intent.getStringExtra(StartService.NAME);
        }
        Toast.makeText(this, "onStartCommand start is Called" + text, Toast.LENGTH_SHORT).show();
        //   stopSelf();// auto stop
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy start is Called", Toast.LENGTH_SHORT).show();
    }
}
