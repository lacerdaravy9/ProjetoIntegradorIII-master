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
import android.widget.TextView;

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

public class tela_cadastro_aluno extends AppCompatActivity {
    private EditText TextAltura01;
    private EditText edit_nome, edit_peso, edit_altura, edit_idade, edit_email, edit_senha, edit_senha1;
    private Button bt_cadastrar;
    String[] mensagens = {"Preencha todos os campos", "Cadastro realizado com sucesso"};
    String clienteID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_aluno);
        edit_altura = findViewById(R.id.edit_altura);
        IniciarComponentes();

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edit_nome.getText().toString();
                String peso = edit_peso.getText().toString();
                String altura = edit_altura.getText().toString();
                String idade = edit_idade.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();
                String senha1 = edit_senha1.getText().toString();

                if (nome.isEmpty() || peso.isEmpty() || altura.isEmpty() || idade.isEmpty() || email.isEmpty() || senha.isEmpty() || senha1.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    CadastrarCliente(v);
                }
            }
        });


        SimpleMaskFormatter sme = new SimpleMaskFormatter("N.NN");
        MaskTextWatcher mtn = new MaskTextWatcher(edit_altura, sme);
        edit_altura.addTextChangedListener(mtn);
    }

    private void CadastrarCliente(View v) {
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();
        String senha1 = edit_senha1.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    SalvarDadosCliente();

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

    public void starttela_login_aluno (View view){
        Intent tela_login_aluno = new Intent(this, tela_login_aluno.class);
        startActivity(tela_login_aluno);
    }

    private void SalvarDadosCliente(){
        String nome = edit_nome.getText().toString();
        String peso = edit_peso.getText().toString();
        String altura = edit_altura.getText().toString();
        String idade = edit_idade.getText().toString();
        String senha1 = edit_senha1.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> clientes = new HashMap<>();
        clientes.put("nome",nome);
        clientes.put("peso",peso);
        clientes.put("altura",altura);
        clientes.put("idade",idade);
        clientes.put("senha1",senha1);

        clienteID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Clientes").document(clienteID);
        documentReference.set(clientes).addOnSuccessListener(new OnSuccessListener<Void>() {
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
        edit_nome = findViewById(R.id.edit_nome);
        edit_peso = findViewById(R.id.edit_peso);
        edit_altura = findViewById(R.id.edit_altura);
        edit_idade = findViewById(R.id.edit_idade);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        edit_senha1 = findViewById(R.id.edit_senha1);
        bt_cadastrar = findViewById(R.id.bt_cadastrar);
    }
}