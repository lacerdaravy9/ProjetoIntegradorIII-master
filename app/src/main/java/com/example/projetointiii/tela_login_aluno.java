package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_login_aluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login_aluno);
    }
    public void starttela_agenda_de_treinos (View view){
        Intent tela_agenda_de_treinos = new Intent(this, tela_agenda_de_treinos.class);
        startActivity(tela_agenda_de_treinos);
    }
    public void starttela_cadastro_aluno (View view){
        Intent tela_cadastro_aluno = new Intent(this, tela_cadastro_aluno.class);
        startActivity(tela_cadastro_aluno);
    }
}