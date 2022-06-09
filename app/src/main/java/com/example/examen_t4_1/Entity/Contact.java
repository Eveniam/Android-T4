package com.example.examen_t4_1.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "url")
    public String url;

    public Contact() {
    }

    public Contact(int id, String name, String descripcion, String url) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.url = url;
    }
}
