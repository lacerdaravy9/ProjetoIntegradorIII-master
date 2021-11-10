package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class tela_login_professor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login_professor);
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
}