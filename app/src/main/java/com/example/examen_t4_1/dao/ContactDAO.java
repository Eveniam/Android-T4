package com.example.examen_t4_1.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.examen_t4_1.Entity.Contact;

import java.util.List;

@Dao
public interface ContactDAO {
    @Query("SELECT * FROM contacts")
    List<Contact> getAll();

    @Query("SELECT * FROM contacts WHERE id = :id")
    Contact find(int id);

    @Insert
    void create(Contact contact);
}
