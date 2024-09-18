package com.northcoders.zeldabosses.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.zeldabosses.dao.JsonBossesObject;
import com.northcoders.zeldabosses.model.Boss;
import com.northcoders.zeldabosses.service.ApiService;
import com.northcoders.zeldabosses.service.BossService;
import com.northcoders.zeldabosses.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BossRepository {
    private List<Boss> bossList;
    private MutableLiveData<List<Boss>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public BossRepository(Application application){
        this.application=application;
    }

    public MutableLiveData<List<Boss>> getMutableLiveData(){
        RetrofitInstance retrofitInstance = new RetrofitInstance();
        ApiService apiService = retrofitInstance.getService();
        Call<JsonBossesObject> call = apiService.getBosses();
        call.enqueue(new Callback<JsonBossesObject>() {
            @Override
            public void onResponse(Call<JsonBossesObject> call, Response<JsonBossesObject> response) {
                BossService bossService = new BossService();
                bossList = bossService.mapJsonToBossList(response.body());
                Log.i(String.valueOf(BossRepository.class), "Getting boss list from BossService");
                mutableLiveData.setValue(bossList);
            }

            @Override
            public void onFailure(Call<JsonBossesObject> call, Throwable t) {
                Log.i("HTTP Failure getting bosses", t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
