package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class ExamService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // khởi tạo 1 lần và ko khởi tạo lại lần nữa, y như thằng onCreate() bên activity
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate Start Service", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
