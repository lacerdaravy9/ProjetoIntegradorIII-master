package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class tela_login_aluno extends AppCompatActivity {
    private EditText edit_email01, edit_senha03;
    private Button bt_login, bt_cadastrar02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login_aluno);
    }
    public void starttela_perfil (View view){
        Intent tela_perfil = new Intent(this, tela_perfil.class);
        startActivity(tela_perfil);
    }
    public void starttela_cadastro_aluno (View view){
        Intent tela_cadastro_aluno = new Intent(this, tela_cadastro_aluno.class);
        startActivity(tela_cadastro_aluno);
    }
    public void starttela_login_aluno (View view){
        Intent tela_login_aluno = new Intent(this, tela_login_aluno.class);
        startActivity(tela_login_aluno);
    }
    public void starttela_login_professor (View view){
        Intent tela_login_professor = new Intent(this, tela_login_professor.class);
        startActivity(tela_login_professor);
    }

}