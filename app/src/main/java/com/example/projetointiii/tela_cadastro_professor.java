package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_cadastro_professor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_professor);
    }
    public void starttela_login_professor (View view){
        Intent tela_login_professor = new Intent(this, tela_login_professor.class);
        startActivity(tela_login_professor);
    }
}