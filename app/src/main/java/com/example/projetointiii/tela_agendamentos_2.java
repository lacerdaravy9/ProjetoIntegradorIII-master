package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_agendamentos_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_agendamentos2);
    }
    public void startTela_De_Treinos(View view){
        Intent Tela_De_Treinos = new Intent(this, Tela_De_Treinos.class);
        startActivity(Tela_De_Treinos);
    }
}