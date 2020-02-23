package com.min.gamequiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    private Button btn_cadastrar;
    private EditText edtEmail;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        auth = FirebaseAuth.getInstance();

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        // BOTÃO CADASTRO DE UM NOVO USUÁRIO
        btn_cadastrar = (Button) findViewById(R.id.btnCadastrar);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();
                validaDadosDeEntrada(email, senha);
            }
        });
    }

    // VALIDA EMAIL
    public static boolean isValidEmailAddressRegex(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    // VALIDA DADOS DE ENTRADA
    private void validaDadosDeEntrada(String email, String senha) {
        boolean isEmailValid = isValidEmailAddressRegex(email);
        if(!isEmailValid) {
            alert("E-mail inválido!");
            return;
        }

        if(senha.length() < 6) {
            alert("A senha deve ter no minímo 6 digítos!");
            return;
        }
        criarUser(email, senha);
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    // CADASTRA NOVO USUÁRIO NO FIREBASE
    private void criarUser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(CadastroUsuarioActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            alert("Usuário cadastrado com sucesso!");
                            edtEmail.setText("");
                            edtSenha.setText("");
                        } else {
                            alert("Não foi possível realizar o cadastro!");
                        }
                    }
                });
    }

    // EXIBE MENSAGEM AO USUÁRIO
    private void alert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
