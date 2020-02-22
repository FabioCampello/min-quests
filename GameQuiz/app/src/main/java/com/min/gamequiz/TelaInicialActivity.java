package com.min.gamequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TelaInicialActivity extends AppCompatActivity {

    private TextView textEmail;
    private TextView textSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Intent intent = getIntent();
        String email = intent.getStringExtra(MainActivity.EMAIL);
        String senha = intent.getStringExtra(MainActivity.SENHA);

        textEmail = findViewById(R.id.txtEmail);
        textEmail.setText(email);

        textSenha = findViewById(R.id.txtSenha);
        textSenha.setText(senha);

    }
}
