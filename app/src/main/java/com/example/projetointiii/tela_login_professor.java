package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class tela_login_professor extends AppCompatActivity {
    private EditText textInputLayout16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login_professor);
        textInputLayout16 = findViewById(R.id.textInputLayout16);


        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNNNNN-N/NN");
        MaskTextWatcher mtw = new MaskTextWatcher(textInputLayout16, smf);
        textInputLayout16.addTextChangedListener(mtw);
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