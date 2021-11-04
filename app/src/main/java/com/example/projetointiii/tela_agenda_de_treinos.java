package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_agenda_de_treinos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_agenda_de_treinos);
    }
    public void starttela_de_agendamentos (View view){
        Intent tela_de_agendamentos = new Intent(this, tela_de_agendamentos.class);
        startActivity(tela_de_agendamentos);
    }
}