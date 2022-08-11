package com.fmastudio.tod.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.fmastudio.tod.R;
import com.fmastudio.tod.Model.ListPlayerModel;

import java.util.List;

public class ListPlayerAdapter extends RecyclerView.Adapter<ListPlayerAdapter.ViewHolder> {
    List<ListPlayerModel> mList ;
    Context ctx;

    public ListPlayerAdapter(List<ListPlayerModel> mList) {
        this.mList = mList;
//        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_player,parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ListPlayerModel listPlayerModel = mList.get(position);
        holder.nama.setText(listPlayerModel.getNama().toString());
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mList.remove(mList.get(position));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView count, nama;
        ImageView btn_delete;
        public ViewHolder(View v)
        {
            super(v);
            nama        = (TextView) v.findViewById(R.id.txt_nama);
            btn_delete  = (ImageView) v.findViewById(R.id.btn_delete);
        }
    }
}