package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tela_Grupo_C extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_grupo_c);
    }
    public void startTela_Agendamento_3 (View view){
        Intent Tela_Agendamento_3 = new Intent(this, Tela_Agendamento_3.class);
        startActivity(Tela_Agendamento_3);
    }
}