package com.min.gamequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private TextView textEmail;
    private TextView textSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent = getIntent();
        String email = intent.getStringExtra(LoginActivity.EMAIL);
        String senha = intent.getStringExtra(LoginActivity.SENHA);

        textEmail = findViewById(R.id.txtEmail);
        textEmail.setText(email);

        textSenha = findViewById(R.id.txtSenha);
        textSenha.setText(senha);

    }
}
