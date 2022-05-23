package com.example.dietapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dietapp.roomdb.Meals;

import java.util.List;

public class MealsAdapterII extends RecyclerView.Adapter<MealsAdapterII.MealAdpaterVH> {

    private List<Meals> mealsList;
    private Context context;

    public MealsAdapterII() {
    }

    public void setData(List<Meals> mealsList){
        this.mealsList = mealsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MealAdpaterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new MealAdpaterVH(
            LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdpaterVH holder, int position) {

        Meals meals = mealsList.get(position);
        String mealname = meals.getMealname();
        int calory = meals.getCalories();
        String mealpicture = meals.getMealpictures();
        holder.mealName.setText(mealname);
        holder.mealcalory.setText(calory);

        Glide.with(holder.mealPic.getContext())
                .load(mealpicture)
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.mealPic);



    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }

    public class MealAdpaterVH extends RecyclerView.ViewHolder{
        ImageView mealPic;
        TextView mealName;
        TextView mealcalory;
        public MealAdpaterVH(@NonNull View itemView) {
            super(itemView);
            mealPic = itemView.findViewById(R.id.mealpicture);
            mealName = itemView.findViewById(R.id.mealname);
            mealcalory = itemView.findViewById(R.id.mealcalories);

        }
    }

}
