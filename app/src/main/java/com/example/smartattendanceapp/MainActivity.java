package com.example.smartattendanceapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menunggu beberapa detik, kemudian pindah ke SplashActivity atau LoginActivity
        new Thread(() -> {
            try {
                Thread.sleep(3000); // waktu delay selama 3 detik
                startActivity(new Intent(MainActivity.this, SplashActivity.class));
                finish(); // tutup MainActivity
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
