package com.example.efe_proyectofinal_cm_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
public class ForgotPasswordActivity extends AppCompatActivity {

    Button btn_recuperar;
    EditText correo_rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getSupportActionBar().setTitle("¿Olvidaste tu contraseña?");

        btn_recuperar=findViewById(R.id.btn_recuperar);
        correo_rec=findViewById(R.id.correo);
        btn_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    public void validar() {
        String correo=correo_rec.getText().toString().trim();
        if(correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            correo_rec.setError("Correo invalido");
            return;
        }
        EnviarCorreo(correo);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void EnviarCorreo(String correo){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAdress = correo;

        auth.sendPasswordResetEmail(emailAdress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPasswordActivity.this, "Correo Enviado :)", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(ForgotPasswordActivity.this, "Correo Invalido :(", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}