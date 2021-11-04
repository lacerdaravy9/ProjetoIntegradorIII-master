package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_de_agendamentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_de_agendamentos);
    }
    public void starttela_agendamentos_2 (View view){
        Intent tela_agendamentos_2 = new Intent(this, tela_agendamentos_2.class);
        startActivity(tela_agendamentos_2);
    }
    public void startTela_De_Treinos (View view){
        Intent Tela_De_Treinos = new Intent(this, Tela_De_Treinos.class);
        startActivity(Tela_De_Treinos);
    }
}