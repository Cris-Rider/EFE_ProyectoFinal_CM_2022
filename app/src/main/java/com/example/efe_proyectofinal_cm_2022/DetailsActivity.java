package com.example.efe_proyectofinal_cm_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.efe_proyectofinal_cm_2022.clases.Headlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    Headlines headlines;
    TextView txt_title, txt_author, txt_time, txt_detail,txt_content;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);

        headlines = (Headlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);

    }
}