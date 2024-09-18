package com.northcoders.zeldabosses.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.zeldabosses.dao.DungeonRecord;
import com.northcoders.zeldabosses.dao.JsonDungeonObject;
import com.northcoders.zeldabosses.service.ApiService;
import com.northcoders.zeldabosses.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Converts the list of URLs for dungeon endpoints into a String for the Boss class constructor
public class DungeonRepository {
    private List<DungeonRecord> dungeons;
    private MutableLiveData<List<DungeonRecord>> mutableLiveData = new MutableLiveData<>();

    // ❓ BossService requires a String, but previously I have returned MutableLiveData
    public String parseDungeons(List<String> dungeonURLs){
        StringBuilder sb = new StringBuilder();

        if (dungeonURLs.isEmpty()) {
            sb.append("Location unknown");
            Log.i(String.valueOf(DungeonRepository.class), "There are no dungeons for this boss");
        } else {
            RetrofitInstance retrofitInstance = new RetrofitInstance();
            ApiService apiService = retrofitInstance.getService();
            sb.append("Known locations: \n");

            for (int i = 0; i < dungeonURLs.size(); i++) {
                String dungeonId = dungeonURLs.get(i).replace("https://zelda.fanapis.com/", "");
                Call<JsonDungeonObject> call = apiService.getDungeon(dungeonId);
                call.enqueue(new Callback<JsonDungeonObject>() {
                    @Override
                    public void onResponse(Call<JsonDungeonObject> call, Response<JsonDungeonObject> response) {
                        DungeonRecord dungeon = response.body().getData();
                        dungeons.add(dungeon);
                        Log.i(String.valueOf(DungeonRepository.class), "Adding dungeon to boss field");
                        sb.append(dungeon.getName().concat("\n"));
                    }

                    @Override
                    public void onFailure(Call<JsonDungeonObject> call, Throwable t) {
                        Log.i("HTTP Failure getting dungeons", t.getMessage());
                    }
                });
            }
            mutableLiveData.setValue(dungeons);
        }
        return sb.toString();
    }
}
