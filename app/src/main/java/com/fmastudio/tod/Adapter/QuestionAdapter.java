package com.fmastudio.tod.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fmastudio.tod.Model.QuestionModel;
import com.fmastudio.tod.R;

import java.util.List;
//
//public class QuestionAdapter extends TextView.Adapter<QuestionAdapter.MyHolder> {
//    String pertanyaan;
//
//    public QuestionAdapter(String pertanyaan) {
//        this.pertanyaan = pertanyaan;
//    }
//
//    @Override
//    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
////        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false);
////        MyHolder holder = new MyHolder(layout);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(MyHolder holder, final int position) {
//        QuestionModel questionModel = pertanyaan;
//        holder.pertanyaan.setText(questionModel.getPertanyaan().toString());
//    }
//
//    @Override
//    public int getItemCount()
//    {
//        return 1;
//    }
//
//    public class MyHolder extends RecyclerView.ViewHolder {
//        TextView pertanyaan;
//
//        public MyHolder(View v)
//        {
//            super(v);
//            pertanyaan = (TextView) v.findViewById(R.id.txt_question);
//        }
//    }
//}