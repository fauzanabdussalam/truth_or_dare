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
import android.widget.Toast;

public class ListPlayerActivity extends AppCompatActivity {

    private ArrayList<ListPlayerModel> listPlayer = new ArrayList<ListPlayerModel>();
    private MaterialButton addBtn, playBtn;
    private TextView namaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_player);

        addBtn  = findViewById(R.id.btn_addplayer);
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
                if(listPlayer.size() > 1) {
                    Intent intent = new Intent(getApplicationContext(),RouletteActivity.class);
                    intent.putExtra("list_player", listPlayer);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Minimal 2 Orang Pemain",Toast.LENGTH_LONG).show();
                }
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
