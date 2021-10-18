package com.example.kelompokfaiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<MainModel.Result> results = new ArrayList<>();
    public MovieAdapter(List<MainModel.Result> results){
        this.results = results;

    }
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        MainModel.Result result = results.get(position);
        holder.tvTitle.setText(result.getTitle());
        holder.tvDescription.setText(result.getOverview());

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
}
