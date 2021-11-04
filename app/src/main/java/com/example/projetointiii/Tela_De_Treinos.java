package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tela_De_Treinos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_de_treinos);
    }
    public void startTela_Grupo_A (View view){
        Intent Tela_Grupo_A = new Intent(this, Tela_Grupo_A.class);
        startActivity(Tela_Grupo_A);
    }
    public void startTela_Grupo_B (View view){
        Intent Tela_Grupo_B = new Intent(this, Tela_Grupo_B.class);
        startActivity(Tela_Grupo_B);
    }
    public void startTela_Grupo_C (View view){
        Intent Tela_Grupo_C = new Intent(this, Tela_Grupo_C.class);
        startActivity(Tela_Grupo_C);
    }
    public void startTela_Grupo_D (View view){
        Intent Tela_Grupo_D = new Intent(this, Tela_Grupo_D.class);
        startActivity(Tela_Grupo_D);
    }
}