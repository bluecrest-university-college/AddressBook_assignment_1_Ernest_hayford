package com.oninvader.appintmentassignment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.ripple.RippleUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    List<User> users;
    Context context;

    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserAdapter.ViewHolder viewHolder, int i) {
        User user = users.get(i);
        viewHolder.name.setText(user.getFirstname()+ " " + user.getLastname() );
        viewHolder.phone.setText("Phone: " + user.getPhone());
        viewHolder.type.setText("Person: " + user.getType());
        viewHolder.date.setText("Date Of Birth: " + user.getDate_of_birth());
        viewHolder.address.setText("Address: " + user.getAddress());
        viewHolder.country.setText("Country: " + user.getCountry());
        viewHolder.zip.setText("Zip Code: " + user.getZip());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, type, date, country, zip, address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone_number);
            type = itemView.findViewById(R.id.user_type);
            date = itemView.findViewById(R.id.birth_day);
            address= itemView.findViewById(R.id.address);
            country = itemView.findViewById(R.id.country);
            zip  = itemView.findViewById(R.id.zip);

        }
    }
}
