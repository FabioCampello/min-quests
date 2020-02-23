package com.min.gamequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;

    private TextView textEmail;
    private TextView textSenha;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        inicializaComponentes();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexao.logout();
                textEmail.setText("");
                textSenha.setText("");
                finish();
            }
        });

    }

    private void inicializaComponentes() {
        textEmail = (TextView) findViewById(R.id.txtEmail);
        textSenha = (TextView) findViewById(R.id.txtSenha);
        btnLogout = (Button) findViewById(R.id.btnLogout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textEmail.setText("");
        textSenha.setText("");
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();
        verificarUsuario();
    }

    private void verificarUsuario() {
        if(user == null) {
            finish();
        } else {
            textEmail.setText(user.getEmail());
            textSenha.setText(user.getUid());
        }
    }

}
