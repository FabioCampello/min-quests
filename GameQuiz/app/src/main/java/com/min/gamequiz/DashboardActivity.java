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

    private TextView edtEmail;
    private TextView edtId;
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
                edtEmail.setText("");
                edtId.setText("");
                finish();
            }
        });

    }

    private void inicializaComponentes() {
        edtEmail = (TextView) findViewById(R.id.edtEmail);
        edtId = (TextView) findViewById(R.id.edtId);
        btnLogout = (Button) findViewById(R.id.btnLogout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtEmail.setText("");
        edtId.setText("");
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();
        verificarUsuario();
    }

    private void verificarUsuario() {
        if(user == null) {
            finish();
        } else {
            edtEmail.setText(user.getEmail());
            edtId.setText(user.getUid());
        }
    }

}
