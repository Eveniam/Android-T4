package com.example.examen_t4_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.examen_t4_1.Adapter.Adaptador;
import com.example.examen_t4_1.Entity.Contact;
import com.example.examen_t4_1.Factorys.RetrofitFactory;
import com.example.examen_t4_1.Services.ContactService;
import com.example.examen_t4_1.dao.ContactDAO;
import com.example.examen_t4_1.database.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();
    SharedPreferences mSharedPref;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDatabase(getApplicationContext());

        mSharedPref = getSharedPreferences("com.example.examen_t4_1.SHARED_PREFERENCES", Context.MODE_PRIVATE);

        String token = mSharedPref.getString("com.example.examen_t4_1.TOKEN", "");



        Retrofit retrofit = RetrofitFactory.build(this);
        ContactService service = retrofit.create(ContactService.class);

        Call<List<Contact>> call = service.getContacts();

        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if(!response.isSuccessful()) {
                    Log.e("APP_VJ20202", "Error de aplicación");
                } else {
                    Log.i("APP_VJ20202", "Respuesta Correcta");
                    contacts = response.body();

                    saveInDatabase(contacts);

                    Adaptador adapter = new Adaptador(contacts);

                    RecyclerView rv = findViewById(R.id.rvContacts);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Log.e("APP_VJ20202", "No hubo conectividad con el servicio web");
            }
        });

    }

    private void saveInDatabase(List<Contact> contacts) {
        ContactDAO dao = db.contactDAO();
        for (Contact contact : contacts) {
            dao.create(contact);
        }
    }
    }
}