package com.example.javafirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    List<UserInfo> list;

    public UserAdapter(List<UserInfo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        UserInfo userInfo = list.get(position);
        holder.tvUsername.setText("Username: " + userInfo.userName);
        holder.tvUserBio.setText("Bio: " + userInfo.userBio);
        holder.tvUserEmail.setText("Email: " + userInfo.userEmail);
        holder.tvUserPassword.setText("Password: " + userInfo.userPassword);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername, tvUserBio, tvUserEmail, tvUserPassword;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvUserBio = itemView.findViewById(R.id.tvUserBio);
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
            tvUserPassword = itemView.findViewById(R.id.tvUserPassword);
        }
    }

}
