package com.example.journalapp;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.journalapp.model.Journal;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder> {

    Context context;
    List<Journal> journalList;

    public MyAdapter(Context context, List<Journal> journalList) {
        this.context = context;
        this.journalList = journalList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.journal_row, parent, false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Journal currentJournal = journalList.get(position);

        holder.title.setText(currentJournal.getTitle());
        holder.thoughts.setText(currentJournal.getThoughts());
        holder.name.setText(currentJournal.getUserName());

        String imageUrl = currentJournal.getImageUrl();


//        String timeAgo = (String) DateUtils.
//                getRelativeTimeSpanString(currentJournal.getTimeAdded().getSeconds() * 1000);
//
//        holder.dateAdded.setText(timeAgo);
        if (currentJournal.getTimeAdded() != null) {
            String timeAgo = (String) DateUtils.getRelativeTimeSpanString(
                    currentJournal.getTimeAdded().getSeconds() * 1000);
            holder.dateAdded.setText(timeAgo);
        } else {
            holder.dateAdded.setText("No Date");
        }


        // Glide Library to display the image
//        Glide.with(context).load(imageUrl).fitCenter().into(holder.image);
        if (imageUrl != null) {
            Glide.with(context)
                    .load(imageUrl)
                    .fitCenter()
                    .into(holder.image);
        } else {
            holder.image.setImageResource(R.drawable.gradient_main); // default image
        }


    }

    @Override
    public int getItemCount() {
        return journalList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        TextView title, thoughts, dateAdded, name;
        ImageView image, shareButton;
        String userId, username;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.journal_title_list);
            thoughts = itemView.findViewById(R.id.journal_thought_list);
            dateAdded = itemView.findViewById(R.id.journal_timestamp_list);
            image = itemView.findViewById(R.id.journal_image_list);
            name = itemView.findViewById(R.id.journal_row_username);

            shareButton = itemView.findViewById(R.id.journal_row_share_button);

        }
    }
}
