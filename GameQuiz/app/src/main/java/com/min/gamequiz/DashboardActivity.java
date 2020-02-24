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

    private TextView edt_email;
    private TextView edt_id;
    private Button btn_logout;
    private Button btn_inicio_jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        inicializaComponentes();
        eventosDeClick();
    }

    @Override
    protected void onStart() {
        super.onStart();
        edt_email.setText("");
        edt_id.setText("");
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();
        verificarUsuario();
    }

    //*********************************************************************
    // INICIALIZA COMPONENTES
    private void inicializaComponentes() {
        edt_email = (TextView) findViewById(R.id.edtEmail);
        edt_id = (TextView) findViewById(R.id.edtId);
        btn_logout = (Button) findViewById(R.id.btnLogout);
        btn_inicio_jogo = (Button) findViewById(R.id.btnInicioJogo);
    }
    //*********************************************************************
    // VERIFICAR USUÁRIO
    private void verificarUsuario() {
        if(user == null) {
            finish();
        } else {
            edt_email.setText(user.getEmail());
            edt_id.setText(user.getUid());
        }
    }

    //*********************************************************************
    // EVENTOS DE CLICK
    private void eventosDeClick() {

        // EVENTO LOGOUT / SAIR DA APLICAÇÃO
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexao.logout();
                edt_email.setText("");
                edt_id.setText("");
                finish();
            }
        });

        // EVENTO INICIAR JOGO
        btn_inicio_jogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

    }

}
