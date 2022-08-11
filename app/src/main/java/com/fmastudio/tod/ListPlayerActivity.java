package com.fmastudio.tod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fmastudio.tod.Adapter.ListPlayerAdapter;
import com.fmastudio.tod.Model.ListPlayerModel;
import com.google.android.material.button.MaterialButton;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;

public class ListPlayerActivity extends AppCompatActivity {

    private List<ListPlayerModel> listPlayer = new ArrayList<>();
    private MaterialButton addBtn, playBtn;
    private TextView namaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_player);

        addBtn = findViewById(R.id.btn_addplayer);
        playBtn = findViewById(R.id.btn_play);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namaText    = findViewById(R.id.txt_addplayer);
                String nama = namaText.getText().toString();

                if(!nama.equals(""))
                {
                    listPlayer.add(new ListPlayerModel(nama));
                    namaText.setText("");
                }

                loadRV();
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), RouletteActivity.class));
            }
        });
    }

    public void loadRV()
    {
        RecyclerView recyclerView = findViewById(R.id.rv_listplayer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListPlayerAdapter(listPlayer));
    }
}
