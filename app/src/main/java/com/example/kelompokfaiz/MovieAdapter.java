package com.example.kelompokfaiz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private List<MainModel.Result> results;
    private OnAdapterListener listener;

    public MovieAdapter(Context context, List<MainModel.Result> results, OnAdapterListener listener){
        this.results = results;
        this.listener = listener;
        this.context = context;
    }
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false)
        );
    }

    public static final String EXTRA_MESSAGE1 = "com.example.kelompokfaiz.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.kelompokfaiz.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.kelompokfaiz.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.kelompokfaiz.MESSAGE4";
    public static final String EXTRA_MESSAGE5 = "com.example.kelompokfaiz.MESSAGE5";

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {

        String title = results.get(position).getTitle();
        String overview = results.get(position).getOverview();
        String poster = results.get(position).getPoster_path();

        holder.tvTitle.setText(title);
        holder.tvDescription.setText(overview);
        Glide.with(context).load("https://image.tmdb.org/t/p/w185/"+ poster).
                into(holder.imgMovie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(EXTRA_MESSAGE1, title);
                intent.putExtra(EXTRA_MESSAGE2, overview);
                intent.putExtra(EXTRA_MESSAGE3, poster);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView tvTitle;
        TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMovie = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }

    public void setData(List<MainModel.Result> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();

    }

    interface OnAdapterListener{
        void onClick(MainModel.Result result);
    }
}

