package com.example.projetointiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class tela_cadastro_aluno extends AppCompatActivity {
    private EditText TextCpf01;
    private EditText TextAltura01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_aluno);
        TextCpf01 = findViewById(R.id.TextCpf01);
        TextAltura01 = findViewById(R.id.TextAltura01);


        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(TextCpf01, smf);
        TextCpf01.addTextChangedListener(mtw);


        SimpleMaskFormatter sme = new SimpleMaskFormatter("N.NN");
        MaskTextWatcher mtn = new MaskTextWatcher(TextAltura01, sme);
        TextAltura01.addTextChangedListener(mtn);
    }
    public void starttela_login_aluno (View view){
        Intent tela_login_aluno = new Intent(this, tela_login_aluno.class);
        startActivity(tela_login_aluno);
    }
}