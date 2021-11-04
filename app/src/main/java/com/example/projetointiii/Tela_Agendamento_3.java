package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tela_Agendamento_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_agendamento_3);
    }
    public void starttela_imc (View view){
        Intent tela_imc = new Intent(this, tela_imc.class);
        startActivity(tela_imc);
    }
}