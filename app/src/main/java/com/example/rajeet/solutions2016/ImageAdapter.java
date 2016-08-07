package com.example.rajeet.solutions2016;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by NIKHIL SANJAY WAGH on 01-08-2016.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MainImages> arrayList;

    public ImageAdapter (Context context, ArrayList<MainImages> object)
    {
        this.context = context;
        arrayList = object;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MainImages obj = arrayList.get(position);

        holder.eventName.setText(obj.getEventName());
        holder.name.setText(obj.getName());
        holder.college.setText(obj.getCollege());
        holder.email.setText(obj.getEmail());
        holder.phone.setText(obj.getPhone());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView eventName;
        TextView name;
        TextView email;
        TextView college;
        TextView phone;

        public ViewHolder(View itemView) {
            super(itemView);

            eventName = (TextView) itemView.findViewById(R.id.eventNameTV);
            name = (TextView) itemView.findViewById(R.id.NameTV);
            email = (TextView) itemView.findViewById(R.id.EmaiTv);
            college = (TextView) itemView.findViewById(R.id.CollegeTV);
            phone =(TextView) itemView.findViewById(R.id.PhoneTv);

        }
    }

}
