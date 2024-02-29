package com.example.restaurantapplinuiyanbdt20051;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapterBDT20051 extends RecyclerView.Adapter<FoodAdapterBDT20051.ViewHolder> {
    ContentValues contentValues;
    Bundle mBundle;
    public List<FoodBDT20051> myFoodList;
    public FoodAdapterBDT20051(List<FoodBDT20051>myFoodList){
        this.myFoodList = myFoodList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = " ";
                int p = holder.getAdapterPosition();
                FoodBDT20051 food = myFoodList.get(p);
                Toast toast = Toast.makeText(v.getContext(),"点击了："+food.getName(),Toast.LENGTH_LONG);

                toast.show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int b = holder.getAdapterPosition();
                FoodBDT20051 food = myFoodList.get(b);
                Toast toast = Toast.makeText(view.getContext(), "长按点击：" + food.getName(), Toast.LENGTH_LONG);
                toast.show();
                return false;
            }
        });

        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FoodBDT20051 food = myFoodList.get(position);
        holder.foodImage.setImageResource(food.getImgid());
        holder.foodname.setText(food.getName());
    }

    @Override
    public int getItemCount() {
        return myFoodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView foodname;
        public ViewHolder(View itemView)
        {
            super(itemView);
            foodImage = itemView.findViewById(R.id.imageViewlinuoyan);
            foodname = itemView.findViewById(R.id.textViewlinuoyan);

        }
    }
}
