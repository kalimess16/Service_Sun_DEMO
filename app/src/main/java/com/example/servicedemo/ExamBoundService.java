package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class ExamBoundService extends Service {

    private final IBinder mIBinder = new DemoBoundService();

    // khởi tạo lần đầu
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate is Called", Toast.LENGTH_SHORT).show();
    }

    // giống như onStart trong  activity khi được khai báo bindService

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "onBind is Called", Toast.LENGTH_SHORT).show();
        return mIBinder;
    }

    /**
     *  không được gọi khi bên activity khai báo là bindService();
     *  nó chỉ được gọi khi bên activity khai báo là startService();
    */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand Bound Called", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }



    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "onUnbind is Called", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Toast.makeText(this, "onRebind is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy is Called", Toast.LENGTH_SHORT).show();
    }

    public class DemoBoundService extends Binder{
        ExamBoundService getService(){
            return ExamBoundService.this;
        }
    }

}
