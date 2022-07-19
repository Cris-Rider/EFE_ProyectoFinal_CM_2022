package com.example.efe_proyectofinal_cm_2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efe_proyectofinal_cm_2022.clases.Headlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorCustom extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<Headlines> headlines;

    public AdaptadorCustom(Context context, List<Headlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.text_tile.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if (headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);

        }
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
