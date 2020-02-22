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

    public static final String EMAIL = "email";
    public static final String SENHA = "senha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_entrar = (Button) findViewById(R.id.btnEntrar);
        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, TelaInicialActivity.class);
        EditText editTextEmail = (EditText) findViewById(R.id.edtEmail);
        EditText editTextSenha = (EditText) findViewById(R.id.edtSenha);

        String email = editTextEmail.getText().toString();
        String senha = editTextSenha.getText().toString();

        intent.putExtra(EMAIL, email);
        intent.putExtra(SENHA, senha);
        startActivity(intent);
    }

}

