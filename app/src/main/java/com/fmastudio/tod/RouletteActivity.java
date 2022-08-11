package com.fmastudio.tod;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fmastudio.tod.Model.ListPlayerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;
import rubikstudio.library.PielView;
import android.graphics.Color;
import android.widget.ImageView;

public class RouletteActivity extends AppCompatActivity {
    ArrayList<ListPlayerModel> listPlayer = new ArrayList<ListPlayerModel>();
    List<LuckyItem> data = new ArrayList<>();
    ImageView truthImg, dareImg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        final LuckyWheelView luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);

        ArrayList<ListPlayerModel> listPlayer = getIntent().getParcelableArrayListExtra("list_player");

        Integer listColor[] = {0xffFFF3E0, 0xffFFE0B2, 0xffFFCC80};

        Integer j = 0;
        for (int i = 0; i < listPlayer.size(); i++)
        {
            if(j > 2){
                j = 0;
            }
            LuckyItem luckyItem1    = new LuckyItem();
            luckyItem1.topText      = listPlayer.get(i).getNama();
            luckyItem1.color        = listColor[j];
            data.add(luckyItem1);
            j++;
        }

        luckyWheelView.setData(data);
        luckyWheelView.setRound(5);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = getRandomIndex();
                luckyWheelView.startLuckyWheelWithTargetIndex(index);
            }
        });

        findViewById(R.id.img_truth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.putExtra("list_player", listPlayer);
                intent.putExtra("jenis", "0");
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), "TRUTH", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.img_dare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.putExtra("list_player", listPlayer);
                intent.putExtra("jenis", "1");
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), "DARE", Toast.LENGTH_SHORT).show();
            }
        });

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(getApplicationContext(), data.get(index).topText, Toast.LENGTH_SHORT).show();

                truthImg = findViewById(R.id.img_truth);
                dareImg = findViewById(R.id.img_dare);

                truthImg.setVisibility(View.VISIBLE);
                dareImg.setVisibility(View.VISIBLE);
            }
        });
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size());
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }
}
