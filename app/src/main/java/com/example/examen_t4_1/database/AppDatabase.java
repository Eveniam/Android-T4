package com.example.examen_t4_1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.examen_t4_1.dao.ContactDAO;
import com.example.examen_t4_1.Entity.Contact;

// cada vez que cambies esta clase aumenta un numero en la version
// mientras desarrollo si tengo problemas con la creacion de dase de datos, desinstalo el app y vuelvo a installar

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDAO contactDAO();

    public static AppDatabase getDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "com.example.androidvj20221.database.contacts.db")
                .allowMainThreadQueries()
                .build();
    }
}
