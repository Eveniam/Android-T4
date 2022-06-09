package com.example.examen_t4_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examen_t4_1.Entity.Contact;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        String contactJson = getIntent().getStringExtra("CONTACT");
        Contact contact = new Gson().fromJson(contactJson, Contact.class);

        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        TextView tvName = findViewById(R.id.tvNombre);
        TextView tvDescrip = findViewById(R.id.tvDescripcion);

        Picasso.get().load("https://loremflickr.com/cache/resized/5238_30052482366_fc6e9350d5_b_640_480_nofilter.jpg").into(ivAvatar);
        tvName.setText(contact.name);
        tvDescrip.setText(contact.descripcion);

    }
}