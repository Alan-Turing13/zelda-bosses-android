package com.northcoders.zeldabosses.dao;

import java.util.List;

public class DungeonRecord {
    List<String> appearances;
    String name;
    String description;
    String id;

    public DungeonRecord(List<String> appearances, String name, String description, String id) {
        this.appearances = appearances;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public DungeonRecord() {
    }

    public List<String> getAppearances() {
        return appearances;
    }

    public void setAppearances(List<String> appearances) {
        this.appearances = appearances;
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
