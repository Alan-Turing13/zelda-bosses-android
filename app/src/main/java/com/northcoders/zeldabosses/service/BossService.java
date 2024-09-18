package com.northcoders.zeldabosses.service;

import com.northcoders.zeldabosses.dao.JsonBossesObject;
import com.northcoders.zeldabosses.model.Boss;
import com.northcoders.zeldabosses.model.BossRecord;
import com.northcoders.zeldabosses.repository.DungeonRepository;

import java.util.ArrayList;
import java.util.List;

public class BossService {

    public List<Boss> mapJsonToBossList(JsonBossesObject jbo){
        DungeonRepository dungeonRepository = new DungeonRepository();
        List<Boss> bosses = new ArrayList<>();

        for (int i=0; i<jbo.getData().size(); i++){
            BossRecord bossRecord = jbo.getData().get(i);
            bosses.add(new Boss(
                i+1L,
                bossRecord.getName(),
                bossRecord.getDescription(),
                dungeonRepository.parseDungeons(bossRecord.getDungeons())
                )
            );
        }
        return bosses;
    }
}
