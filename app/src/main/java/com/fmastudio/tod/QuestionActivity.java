package com.fmastudio.tod;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import android.widget.ProgressBar;

import java.util.ArrayList;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.fmastudio.tod.Model.ListPlayerModel;
import com.fmastudio.tod.Model.QuestionModel;
import com.fmastudio.tod.Model.ResponseModel;
import com.fmastudio.tod.Api.ApiService;
import com.fmastudio.tod.Api.ApiEndPoint;

public class QuestionActivity extends AppCompatActivity {
    ArrayList<ListPlayerModel> listPlayer = new ArrayList<ListPlayerModel>();
    TextView title, question;
    MaterialButton playAgain;
    ProgressBar progressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ArrayList<ListPlayerModel> listPlayer = getIntent().getParcelableArrayListExtra("list_player");
        String jenis = getIntent().getStringExtra("jenis");
        String str_jenis = (jenis.equals("0"))?"TRUTH":"DARE";

        title    = findViewById(R.id.txt_title);
        question = findViewById(R.id.txt_question);
        playAgain = findViewById(R.id.btn_play_again);
        progressBar = findViewById(R.id.progress_bar);

        title.setText(str_jenis);

        getDataQuestion(jenis);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RouletteActivity.class);
                intent.putExtra("list_player", listPlayer);
                startActivity(intent);
            }
        });
    }

    private void getDataQuestion(String jenis)
    {
        //Declare Retrofit
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);

        progressBar = findViewById(R.id.progress_bar);
        Call<ResponseModel> call = api.getQuestion(jenis);
        call.enqueue(new Callback<ResponseModel>()
        {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String statusCode = response.body().getStatus();
                System.out.println("STATUS CODE "+statusCode);
                progressBar.setVisibility(View.GONE);
                if (statusCode.equals("success")) {
                    question.setText(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.e("Error", "Error msg: ", t);
                Toast.makeText(QuestionActivity.this, "Oops, your connection is WONGKY! ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
