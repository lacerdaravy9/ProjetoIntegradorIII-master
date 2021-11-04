package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_login_professor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login_professor);
    }
    public void starttela_agenda_de_treinos (View view){
        Intent tela_agenda_de_treinos = new Intent(this, tela_agenda_de_treinos.class);
        startActivity(tela_agenda_de_treinos);
    }
    public void starttela_cadastro_professor (View view){
        Intent tela_cadastro_professor = new Intent(this, tela_cadastro_professor.class);
        startActivity(tela_cadastro_professor);
    }
}