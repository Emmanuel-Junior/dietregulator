package com.example.dietapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MealbtnAdapter extends ArrayAdapter<Mealbtn> {
    private Context mContext;
    private int mResource;

    public MealbtnAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Mealbtn> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.mealbtnpic);

        TextView mealbtnName = convertView.findViewById(R.id.addmealtxt);
        TextView mealbtndes = convertView.findViewById(R.id.mealbtnsubtitle);

        imageView.setImageResource(getItem(position).getImage());

        mealbtnName.setText(getItem(position).getName());

        mealbtndes.setText(getItem(position).getDes());


        return  convertView;
    }
}
