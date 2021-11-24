package com.example.kelompokfaiz;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder>{
    private List<FavoriteList>favoriteLists;

    Context context;


    public FavoriteAdapter(List<FavoriteList>favoriteLists,Context context){
        this.favoriteLists=favoriteLists;
        this.context=context;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.favorite_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i){
        FavoriteList fl=favoriteLists.get(i);
        Glide.with(context).load("https://image.tmdb.org/t/p/w185/"+ fl.getImage()).
                into(viewHolder.img);
        viewHolder.tv.setText(fl.getName());
        viewHolder.tvdesc.setText(fl.getOverview());

    }
    @Override
    public int getItemCount() { return favoriteLists.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv, tvdesc;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.fimgMovie);
            tv=(TextView)itemView.findViewById(R.id.ftvTitle);
            tvdesc = itemView.findViewById(R.id.ftvDescription);
        }
    }
}
