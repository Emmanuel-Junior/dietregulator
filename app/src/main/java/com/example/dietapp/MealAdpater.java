package com.example.dietapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MealAdpater extends FirebaseRecyclerAdapter<MainModel,MealAdpater.myViewHolder> {

    private OnNoteListener monNoteListener;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MealAdpater(@NonNull FirebaseRecyclerOptions<MainModel> options, OnNoteListener onNoteListener) {
        super(options);
        this.monNoteListener = onNoteListener;

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {


        holder.name.setText(model.getName());
        holder.calories.setText(model.getCalories()+" Kcal");

        Glide.with(holder.img.getContext())
                .load(model.getPicture())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new myViewHolder(view, monNoteListener);
        //return null;
    }

    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CircleImageView img;
        TextView name, calories;
        OnNoteListener onNoteListener;

        public myViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.mealpicture);
            name = (TextView)itemView.findViewById(R.id.mealname);
            calories = (TextView)itemView.findViewById(R.id.mealcalories);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    public interface OnNoteListener{

        void onNoteClick(int position);
    }
}
