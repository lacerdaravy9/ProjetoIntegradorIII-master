package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class tela_cadastro_professor extends AppCompatActivity {
    private EditText edit_telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_professor);
        edit_telefone = findViewById(R.id.edit_telefone);


        SimpleMaskFormatter smf = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(edit_telefone, smf);
        edit_telefone.addTextChangedListener(mtw);
    }
    public void starttela_login_professor (View view){
        Intent tela_login_professor = new Intent(this, tela_login_professor.class);
        startActivity(tela_login_professor);
    }
}