package com.bhaliya72.api_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder > {
    private List<post_pojo> datalist;
    private Context context;



    // data is passed into the constructor
   public Adapter(Context context, List<post_pojo> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    class CustomViewHolder extends  RecyclerView.ViewHolder {
        TextView heding,sub_heading,mail_heading;
        ImageView imageView;

        CustomViewHolder(View itemView) {
            super(itemView);

            heding =itemView.findViewById(R.id.heading);
            sub_heading = itemView.findViewById(R.id.sub_heding);
            mail_heading = itemView.findViewById(R.id.mail_heding);
            imageView = itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View view = layoutInflater.inflate(R.layout.list_api,parent,false);
       return new CustomViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
       holder.heding.setText(datalist.get(position).getTitle());
       holder.mail_heading.setText(datalist.get(position).getUrl());
        try {
            Picasso.get().load((datalist.get(position).getThumbnailUrl())).into(holder.imageView);
        }catch (Exception e){
            Glide.with(context).load(datalist.get(position).getThumbnailUrl()).into(holder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }





}
