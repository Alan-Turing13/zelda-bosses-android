package com.northcoders.zeldabosses.service;

import com.northcoders.zeldabosses.dao.DungeonRecord;
import com.northcoders.zeldabosses.dao.JsonBossesObject;
import com.northcoders.zeldabosses.dao.JsonDungeonObject;
import com.northcoders.zeldabosses.model.Boss;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/bosses?limit=100")
    Call<JsonBossesObject> getBosses();

    // ❓ is this the correct way to pass in a path variable to Retrofit @GET annotation
    @GET("api/dungeons/{dungeonId}")
    Call<JsonDungeonObject> getDungeon(String dungeonId);
}
