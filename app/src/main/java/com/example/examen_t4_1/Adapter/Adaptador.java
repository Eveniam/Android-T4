package com.example.examen_t4_1.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_t4_1.ContactActivity;
import com.example.examen_t4_1.Entity.Contact;
import com.example.examen_t4_1.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ContactViewHoler> {

    List<Contact> contactos;
    public Adaptador(List<Contact> contacts){
        this.contactos = contacts;
    }

    @NonNull
    @Override
    public ContactViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);
        return new ContactViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHoler holder, int position) {
        View itemView = holder.itemView;

        Contact contact = contactos.get(position);
        TextView tvName = itemView.findViewById(R.id.tvNombre);
        TextView tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        ImageView ivAvatar = itemView.findViewById(R.id.ivAvatar);

        tvName.setText(contact.name);
        tvDescripcion.setText(contact.descripcion);
        Picasso.get().load("https://www.stickpng.com/es/img/dibujos-animados/demon-slayer-anime/demon-slayer-kimetsu-no-yaiba-logo.png").into(ivAvatar);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), ContactActivity.class);

                String contactJSON = new Gson().toJson(contact);
                intent.putExtra("CONTACT", contactJSON);

                itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    class ContactViewHoler extends RecyclerView.ViewHolder{

        public ContactViewHoler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
