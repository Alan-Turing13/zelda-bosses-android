package com.northcoders.zeldabosses;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.zeldabosses.databinding.ActivityMainBinding;
import com.northcoders.zeldabosses.model.Boss;
import com.northcoders.zeldabosses.repository.BossRepository;
import com.northcoders.zeldabosses.viewmodel.BossAdapter;
import com.northcoders.zeldabosses.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Boss> bossList;
    BossAdapter bossAdapter;
    MainActivityViewModel mainActivityViewModel;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycler), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        Application application = new Application();
        BossRepository bossRepository = new BossRepository(application);
        bossRepository.getMutableLiveData();
        getAllBosses();
    }

    private void getAllBosses() {
        mainActivityViewModel.getAll().observe(this, new Observer<List<Boss>>() {
            @Override
            public void onChanged(List<Boss> bosses) {
                bossList = bosses;
                Log.d("MainActivity", ".getAllBosses() came back size ".concat(String.valueOf(bossList.size())));
                displayBosses();
            }
        });
    }

    private void displayBosses() {
        recyclerView = activityMainBinding.recycler;
        bossAdapter = new BossAdapter(bossList, this);
        Log.d("MainActivity", ".displayBosses() came back size ".concat(String.valueOf(bossList.size())));
        recyclerView.setAdapter(bossAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        bossAdapter.notifyDataSetChanged();
    }
}