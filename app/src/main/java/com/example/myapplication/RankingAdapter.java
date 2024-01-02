package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {
    Context context;
    ArrayList<RankingData> rankingDataArrayList = new ArrayList<>();
    RankingAdapter(Context context) {this.context = context;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_rank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RankingData rankingData = rankingDataArrayList.get(position);

        holder.ranked_movie_title.setText(String.valueOf(rankingData.getTitle()));
        holder.tv_score.setText(String.valueOf(Math.round(rankingData.getAvg_score() * 10.0f)/10.0f));
        holder.ratingBar_avg.setRating(rankingData.getAvg_score());
    }

    @Override
    public int getItemCount() { return rankingDataArrayList.size(); }
    public void removeItem(){ rankingDataArrayList.clear(); }
    public void addItem(RankingData item){
        rankingDataArrayList.add(item);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView ranked_movie_title, tv_score;
        RatingBar ratingBar_avg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ranked_movie_title = itemView.findViewById(R.id.ranked_movie_title);
            tv_score = itemView.findViewById(R.id.score_text);
            ratingBar_avg = itemView.findViewById(R.id.ratingBar_avg);
        }
    }
}
