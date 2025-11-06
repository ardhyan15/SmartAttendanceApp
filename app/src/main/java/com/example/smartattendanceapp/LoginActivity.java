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
