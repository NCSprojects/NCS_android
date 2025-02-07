package com.example.ncs_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BoxAdapter extends RecyclerView.Adapter<BoxAdapter.CardViewHolder> {
    //3,5층 구성 페이지의 리사이클 어뎁터
    private List<CardItemBox> cardItemBoxes;

    public BoxAdapter(List<CardItemBox> cardItemBoxes) {
        this.cardItemBoxes = cardItemBoxes;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_box_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItemBox item = cardItemBoxes.get(position);
        holder.image.setImageResource(item.getImageResId());
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.time.setText(item.getTime());
    }

    @Override
    public int getItemCount() {
        return cardItemBoxes.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, description, time;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            time = itemView.findViewById(R.id.time);
        }
    }
}