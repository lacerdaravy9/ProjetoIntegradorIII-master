package com.example.projetointiii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class tela_login_aluno extends AppCompatActivity {
    private EditText edit_email01, edit_senha03;
    private Button bt_login, bt_cadastrar02;
    String[] mensagens = {"Preencha todos os campos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login_aluno);
        bt_login = findViewById(R.id.bt_login);

        IniciarComponentes();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tela_login_aluno.this,tela_cadastro_aluno.class);
                startActivity(intent);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edit_email01.getText().toString();
                String senha03 = edit_senha03.getText().toString();

                if (email.isEmpty() || senha03.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    AutenticarCliente(v);
                }
            }
        });
    }

    private void AutenticarCliente(View view){

        String email01 = edit_email01.getText().toString();
        String senha03 = edit_senha03.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email01,senha03).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tela_perfil();
                        }
                    }, 3000);
                }else {
                    String erro;

                    try {
                        throw task.getException();
                    }catch (Exception e){
                        erro = "Erro ao fazer login do cliente";
                    }
                    Snackbar snackbar = Snackbar.make(view,erro,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        FirebaseUser clienteAtual = FirebaseAuth.getInstance().getCurrentUser();

        if (clienteAtual != null){
            tela_perfil();
        }
    }

    private void tela_perfil(){
        Intent intent = new Intent(tela_login_aluno.this,tela_perfil.class);
        startActivity(intent);
        finish();
    }

    public void starttela_perfil(View view) {
        Intent tela_perfil = new Intent(this, tela_perfil.class);
        startActivity(tela_perfil);
    }

    public void starttela_cadastro_aluno(View view) {
        Intent tela_cadastro_aluno = new Intent(this, tela_cadastro_aluno.class);
        startActivity(tela_cadastro_aluno);
    }

    public void starttela_login_aluno(View view) {
        Intent tela_login_aluno = new Intent(this, tela_login_aluno.class);
        startActivity(tela_login_aluno);
    }

    public void starttela_login_professor(View view) {
        Intent tela_login_professor = new Intent(this, tela_login_professor.class);
        startActivity(tela_login_professor);
    }

    private void IniciarComponentes(){
        edit_email01 = findViewById(R.id.edit_email01);
        edit_senha03 = findViewById(R.id.edit_senha03);
        bt_login = findViewById(R.id.bt_login);
        bt_cadastrar02 = findViewById(R.id.bt_cadastrar02);
    }

}