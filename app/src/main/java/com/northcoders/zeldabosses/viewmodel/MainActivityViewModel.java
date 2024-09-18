package com.northcoders.zeldabosses.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.zeldabosses.model.Boss;
import com.northcoders.zeldabosses.repository.BossRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private BossRepository bossRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.bossRepository = new BossRepository(application);
    }

    public LiveData<List<Boss>> getAll(){
        return bossRepository.getMutableLiveData();
    }
}
