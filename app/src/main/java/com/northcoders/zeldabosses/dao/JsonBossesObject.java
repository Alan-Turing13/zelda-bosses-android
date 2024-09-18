package com.northcoders.zeldabosses.dao;

import com.northcoders.zeldabosses.model.BossRecord;

import java.util.List;

public class JsonBossesObject {
    boolean success;
    int count;
    List<BossRecord> data;

    public JsonBossesObject(boolean success, int count, List<BossRecord> data) {
        this.success = success;
        this.count = count;
        this.data = data;
    }

    public JsonBossesObject() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BossRecord> getData() {
        return data;
    }

    public void setData(List<BossRecord> data) {
        this.data = data;
    }
}
