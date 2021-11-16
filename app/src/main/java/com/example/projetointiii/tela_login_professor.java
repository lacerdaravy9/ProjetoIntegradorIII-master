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

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class tela_login_professor extends AppCompatActivity {
    private EditText edit_email02, edit_senha04;
    private Button bt_login01, bt_cadastrar03;
    String[] mensagens = {"Preencha todos os campos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login_professor);
        bt_login01 = findViewById(R.id.bt_login01);

        IniciarComponentes();

        bt_login01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tela_login_professor.this,tela_cadastro_professor.class);
                startActivity(intent);
            }
        });

        bt_login01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email02 = edit_email02.getText().toString();
                String senha04 = edit_senha04.getText().toString();

                if (email02.isEmpty() || senha04.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    AutenticarPersonal(v);
                }
            }
        });
    }

    private void AutenticarPersonal(View view){

        String email02 = edit_email02.getText().toString();
        String senha04 = edit_senha04.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email02,senha04).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() { tela_perfil(); }
                    }, 3000);
                }else {
                    String erro;

                    try {
                        throw task.getException();
                    }catch (Exception e){
                        erro = "Erro ao fazer login do personal";
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

        FirebaseUser personalAtual = FirebaseAuth.getInstance().getCurrentUser();

        if (personalAtual != null){
            tela_perfil();
        }
    }

    private void tela_perfil(){
        Intent intent = new Intent(tela_login_professor.this,tela_perfil.class);
        startActivity(intent);
        finish();
    }
    public void starttela_perfil_personal (View view){
        Intent tela_perfil_personal = new Intent(this, tela_perfil_personal.class);
        startActivity(tela_perfil_personal);
    }
    public void starttela_cadastro_professor (View view){
        Intent tela_cadastro_professor = new Intent(this, tela_cadastro_professor.class);
        startActivity(tela_cadastro_professor);
    }
    public void starttela_login_aluno (View view){
        Intent tela_login_aluno = new Intent(this, tela_login_aluno.class);
        startActivity(tela_login_aluno);
    }
    public void starttela_login_professor (View view){
        Intent tela_login_professor = new Intent(this, tela_login_professor.class);
        startActivity(tela_login_professor);
    }

    private void IniciarComponentes(){
        edit_email02 = findViewById(R.id.edit_email02);
        edit_senha04 = findViewById(R.id.edit_senha04);
        bt_login01 = findViewById(R.id.bt_login01);
        bt_cadastrar03 = findViewById(R.id.bt_cadastrar03);
    }
}