package com.android.roomdbinjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.roomdbinjava.db.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {
        User user = userList.get(position);
        holder.id.setText(""+user.getId());
        holder.tvFirstName.setText(this.userList.get(position).name);
        holder.tvLastName.setText(this.userList.get(position).lastName);
    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView tvFirstName;
        TextView tvLastName;

        public MyViewHolder(View view) {
            super(view);
             id = view.findViewById(R.id.id);
             tvFirstName = view.findViewById(R.id.tvFirstName);
             tvLastName = view.findViewById(R.id.tvLastName);

        }
    }
}
