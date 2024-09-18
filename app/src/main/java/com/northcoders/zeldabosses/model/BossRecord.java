package com.northcoders.zeldabosses.model;

import java.util.List;

public class BossRecord {
    List<String> appearances;
    List<String> dungeons;
    String name;
    String description;
    String id;

    public BossRecord(List<String> appearances, List<String> dungeons, String name, String description, String id) {
        this.appearances = appearances;
        this.dungeons = dungeons;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public BossRecord() {
    }

    public List<String> getAppearances() {
        return appearances;
    }

    public void setAppearances(List<String> appearances) {
        this.appearances = appearances;
    }

    public List<String> getDungeons() {
        return dungeons;
    }

    public void setDungeons(List<String> dungeons) {
        this.dungeons = dungeons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
