package com.northcoders.zeldabosses.dao;

public class JsonDungeonObject {
    boolean success;
    DungeonRecord data;

    public JsonDungeonObject(boolean success, DungeonRecord data) {
        this.success = success;
        this.data = data;
    }

    public JsonDungeonObject() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DungeonRecord getData() {
        return data;
    }

    public void setData(DungeonRecord data) {
        this.data = data;
    }
}
