package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_cadastro_aluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_aluno);
    }
    public void starttela_login_aluno (View view){
        Intent tela_login_aluno = new Intent(this, tela_login_aluno.class);
        startActivity(tela_login_aluno);
    }
}