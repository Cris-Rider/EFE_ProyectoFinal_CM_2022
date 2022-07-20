package com.example.efe_proyectofinal_cm_2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efe_proyectofinal_cm_2022.clases.Headlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorCustom extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<Headlines> headlines;
    private SelectListener listener;

    public AdaptadorCustom(Context context, List<Headlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
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

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.OnNewsClicked(headlines.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
