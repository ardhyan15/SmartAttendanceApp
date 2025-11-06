# 🧾 Smart Attendance App

Aplikasi **Smart Attendance App** adalah aplikasi absensi sederhana berbasis Android yang dibuat menggunakan **Java** dan **Android Studio (Android 10)**.  
Aplikasi ini memiliki tiga bagian utama:
- **Splash Screen**
- **Login Page**
- **Dashboard Page**

---

## 📜 Kode Lengkap Proyek

```java
// ================================
// 📁 com/example/smartattendanceapp/SplashActivity.java
// ================================
package com.example.smartattendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Splash screen tampil selama 3 detik
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();  // Tutup SplashActivity setelah beralih
        }, 3000); // Waktu splash screen
    }
}

// ================================
// 📁 com/example/smartattendanceapp/LoginActivity.java
// ================================
package com.example.smartattendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String user = etUsername.getText().toString();
            String pass = etPassword.getText().toString();

            // Validasi username dan password
            if (user.equals("Amanda") && pass.equals("1234")) {
                // Kirim username ke DashboardActivity
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                intent.putExtra("username", user);  // Menambahkan username ke Intent
                startActivity(intent);
                finish();  // Tutup LoginActivity
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

// ================================
// 📁 com/example/smartattendanceapp/DashboardActivity.java
// ================================
package com.example.smartattendanceapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView tvWelcome = findViewById(R.id.tvWelcome);

        // Ambil data username dari Intent
        String username = getIntent().getStringExtra("username");
        tvWelcome.setText("Selamat datang, " + username + "!");
    }
}

// ================================
// 📄 res/layout/activity_splash.xml
// ================================
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/white">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:src="@mipmap/ic_launcher"
        android:layout_centerInParent="true" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Smart Attendance App"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_below="@id/imageView"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp" />
</RelativeLayout>

// ================================
// 📄 res/layout/activity_login.xml
// ================================
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp"
    android:gravity="center"
    android:background="@color/white">

    <EditText
        android:id="@+id/etUsername"
        android:hint="Username"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPersonName"
        android:layout_marginBottom="16dp" />

    <EditText
        android:id="@+id/etPassword"
        android:hint="Password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPassword"
        android:layout_marginBottom="24dp" />

    <Button
        android:id="@+id/btnLogin"
        android:text="Login"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>

// ================================
// 📄 res/layout/activity_dashboard.xml
// ================================
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp"
    android:background="@color/white">

    <TextView
        android:id="@+id/tvWelcome"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Selamat datang!"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_centerInParent="true" />
</RelativeLayout>

// ================================
// 📄 AndroidManifest.xml
// ================================
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.smartattendanceapp">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="Smart Attendance App"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.AppCompat.Light.NoActionBar">

        <activity android:name=".DashboardActivity" />
        <activity android:name=".LoginActivity" />
        <activity android:name=".SplashActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
