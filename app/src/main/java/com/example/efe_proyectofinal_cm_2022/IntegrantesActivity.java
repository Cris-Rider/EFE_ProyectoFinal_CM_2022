package com.example.efe_proyectofinal_cm_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class IntegrantesActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrantes);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mAuth = FirebaseAuth.getInstance();
        switch (item.getItemId()) {
            case R.id.logout:
                mAuth.signOut();
                signOutUser();
                return true;
            case R.id.btintegrantes:
                Intent mainActivity1 = new Intent(IntegrantesActivity.this, IntegrantesActivity.class);
                startActivity(mainActivity1);
                finish();
                return true;
            case R.id.bthome:
                Intent mainActivity2 = new Intent(IntegrantesActivity.this, MainActivity.class);
                startActivity(mainActivity2);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void signOutUser() {
        Intent mainActivity = new Intent(IntegrantesActivity.this, LoginActivity.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainActivity);
        finish();
    }
}