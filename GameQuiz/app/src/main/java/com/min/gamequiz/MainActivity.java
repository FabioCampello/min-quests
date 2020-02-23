package com.min.gamequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private Button btn_entrar;
    private Button btn_novo_cadastro;
    private Button btn_esquecisenha;

    public static final String EMAIL = "email";
    public static final String SENHA = "senha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BOTÃO LOGIN
        btn_entrar = (Button) findViewById(R.id.btnEntrar);
        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticar(v);
            }
        });

        // BOTÃO NOVO CADASTRO DE USUÁRIO
        btn_novo_cadastro = (Button) findViewById(R.id.btnNovoCadastro);
        btn_novo_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarNovoUsuario(v);
            }
        });

        // BOTÃO ESQUECI A SENHA
        btn_esquecisenha = (Button) findViewById(R.id.btnEsqueciSenha);
        btn_esquecisenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esqueciAhSenha(v);
            }
        });

    }

    // LOGIN/AUTENTICAÇÃO
    public void autenticar(View view) {
        Intent intent = new Intent(this, TelaInicialActivity.class);
        EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        EditText edtSenha = (EditText) findViewById(R.id.edtSenha);

        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();

        intent.putExtra(EMAIL, email);
        intent.putExtra(SENHA, senha);
        startActivity(intent);
    }

    // CADASTRAR NOVO USUÁRIO
    public void cadastrarNovoUsuario(View view) {
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }

    // ESQUECI A SENHA
    public void esqueciAhSenha(View view) {
        Intent intent = new Intent(this, EsqueciSenhaActivity.class);
        startActivity(intent);
    }

}

