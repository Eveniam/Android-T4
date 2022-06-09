package com.example.examen_t4_1.Services;

import com.example.examen_t4_1.Entity.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ContactService {
    @GET("c236cb7f-f90b-41c5-8985-70c4ad6cbbae")
    Call<List<Contact>> getContacts();

    // contacts/:id
    @GET("contacts/{id}")
    Call<Contact> findContact(@Path("id") int id);

    @POST("contacts")
    Call<Contact> create(@Body Contact contact);

    @PUT("contacts/{id}")
    Call<Contact> update(@Path("id") int id, @Body Contact contact);

    @DELETE("contacts/{id}")
    Call<Contact> delete(@Path("id") int id);
}
