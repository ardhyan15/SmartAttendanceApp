package com.example.smartattendanceapp;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvTime, tvAbsenStatus, tvWelcomeMessage;
    private Button btnAbsenMasuk, btnAbsenKeluar;
    private Handler handler;
    private Runnable timeUpdateRunnable;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Mengambil username yang dikirimkan dari LoginActivity
        username = getIntent().getStringExtra("username");

        tvTime = findViewById(R.id.tvTime);
        tvAbsenStatus = findViewById(R.id.tvAbsenStatus);
        tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);  // TextView untuk nama pengguna
        btnAbsenMasuk = findViewById(R.id.btnAbsenMasuk);
        btnAbsenKeluar = findViewById(R.id.btnAbsenKeluar);

        // Menampilkan pesan selamat datang
        tvWelcomeMessage.setText("Selamat datang, " + username);

        handler = new Handler();
        timeUpdateRunnable = new Runnable() {
            @Override
            public void run() {
                updateTime();
                handler.postDelayed(this, 1000); // update tiap 1 detik
            }
        };
        handler.post(timeUpdateRunnable);

        // Tombol Absen Masuk
        btnAbsenMasuk.setOnClickListener(v -> {
            String waktuSekarang = getCurrentTime();
            tvAbsenStatus.setText("✅ Absen Masuk: " + waktuSekarang);
        });

        // Tombol Absen Keluar
        btnAbsenKeluar.setOnClickListener(v -> {
            String waktuSekarang = getCurrentTime();
            tvAbsenStatus.setText("⏰ Absen Keluar: " + waktuSekarang);
        });
    }

    // Fungsi untuk memperbarui jam real-time
    private void updateTime() {
        tvTime.setText("Waktu: " + getCurrentTime());
    }

    // Fungsi untuk mendapatkan waktu sekarang
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(timeUpdateRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.post(timeUpdateRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(timeUpdateRunnable);
    }
}
