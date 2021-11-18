package com.example.projetointiii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class tela_cadastro_professor extends AppCompatActivity {
    private EditText edit_nome1, edit_idade1, edit_email1, edit_senha01, edit_senha02;
    private Button bt_cadastrar01;
    String[] mensagens = {"Preencha todos os campos", "Cadastro realizado com sucesso"};
    String personalID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_professor);
        IniciarComponentes();

        bt_cadastrar01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome1 = edit_nome1.getText().toString();
                String idade1 = edit_idade1.getText().toString();
                String email1 = edit_email1.getText().toString();
                String senha01 = edit_senha01.getText().toString();
                String senha02 = edit_senha02.getText().toString();

                if (nome1.isEmpty() || idade1.isEmpty() || email1.isEmpty() || senha01.isEmpty() || senha02.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    CadastrarPersonal(v);
                }
            }
        });
    }

    private void CadastrarPersonal(View v) {
        String email1 = edit_email1.getText().toString();
        String senha01 = edit_senha01.getText().toString();
        String senha02 = edit_senha02.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email1,senha01).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    SalvarDadosPersonal();

                    Snackbar snackbar = Snackbar.make(v,mensagens[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    String erro;
                    try {
                        throw task.getException();

                    }catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Digite uma senha com no mínimo 6 caracteres";
                    }catch (FirebaseAuthUserCollisionException e) {
                        erro = "Esta conta já foi cadastrada";
                    }catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "E-mail inválido";
                    }catch (Exception e){
                        erro = "Erro ao cadastrar cliente";
                    }

                    Snackbar snackbar = Snackbar.make(v,erro,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                }
            }
        });
    }

    public void starttela_login_professor (View view){
        Intent tela_login_professor = new Intent(this, tela_login_professor.class);
        startActivity(tela_login_professor);
    }

    private void SalvarDadosPersonal(){
        String nome1 = edit_nome1.getText().toString();
        String idade1 = edit_idade1.getText().toString();
        String email1 = edit_email1.getText().toString();
        String senha02 = edit_senha02.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> personais = new HashMap<>();
        personais.put("nome",nome1);
        personais.put("idade",idade1);
        personais.put("email",email1);
        personais.put("senha02",senha02);

        personalID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Personais").document(personalID);
        documentReference.set(personais).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db","Sucesso ao salvar os dados");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db_error","Erro ao salvar os dados" + e.toString());
                    }
                });
    }

    private void IniciarComponentes(){
        edit_nome1 = findViewById(R.id.edit_nome1);
        edit_idade1 = findViewById(R.id.edit_idade1);
        edit_email1 = findViewById(R.id.edit_email);
        edit_senha01 = findViewById(R.id.edit_senha01);
        edit_senha02 = findViewById(R.id.edit_senha02);
        bt_cadastrar01 = findViewById(R.id.bt_cadastrar01);
    }
}
