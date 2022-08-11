package com.fmastudio.tod;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.fmastudio.tod.Model.ListPlayerModel;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.fmastudio.tod.Model.ListPlayerModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    ArrayList<ListPlayerModel> listPlayer = new ArrayList<ListPlayerModel>();
    TextView title, question;
    MaterialButton playAgain;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ArrayList<ListPlayerModel> listPlayer = getIntent().getParcelableArrayListExtra("list_player");
        String jenis = getIntent().getStringExtra("jenis");

        title    = findViewById(R.id.txt_title);
        question = findViewById(R.id.txt_question);
        playAgain = findViewById(R.id.btn_play_again);

        if(jenis.equals("0")) {
            title.setText("TRUTH");
        }
        else {
            title.setText("DARE");
        }

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RouletteActivity.class);
                intent.putExtra("list_player", listPlayer);
                startActivity(intent);
            }
        });
    }
}
