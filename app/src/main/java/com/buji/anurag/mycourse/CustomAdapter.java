package com.buji.anurag.mycourse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<course>my_List;
    Context context;

    public CustomAdapter() {
        super();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final course course=my_List.get(position);
        holder.tv1.setText(course.getDuration());
        holder.tv2.setText(course.getVenue());
        holder.tv3.setText(course.getDate());
        holder.tv4.setText(course.getDiscription());
        holder.tv5.setText(course.getTitle());

    }

    @Override
    public int getItemCount() {
        return my_List.size();
    }

    public CustomAdapter(List<course> my_List, Context context) {
        this.my_List = my_List;
        this.context = context;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4,tv5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.t1);
            tv2=itemView.findViewById(R.id.t2);
            tv3=itemView.findViewById(R.id.t3);
            tv4=itemView.findViewById(R.id.t4);
            tv5=itemView.findViewById(R.id.t5);
        }
    }
}
