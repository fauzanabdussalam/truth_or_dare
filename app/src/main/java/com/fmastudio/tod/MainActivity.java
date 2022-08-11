package com.fmastudio.tod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MaterialButton startBtn, aboutBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn    = findViewById(R.id.btn_start);
        aboutBtn    = findViewById(R.id.btn_about);
        exitBtn     = findViewById(R.id.btn_exit);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListPlayerActivity.class));
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AboutAppsActivity.class));
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogExit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        dialogExit();
    }

    public void dialogExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Apakah anda yakin ingin keluar dari aplikasi?");
        builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}