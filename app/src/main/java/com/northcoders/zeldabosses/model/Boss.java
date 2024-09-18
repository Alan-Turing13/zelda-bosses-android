package com.northcoders.zeldabosses.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Boss extends BaseObservable {
    private long id;
    private String name;
    private String dungeons;
    private String description;
    private String image_url;

    public Boss(long id, String name, String dungeons, String description) {
        this.id = id;
        this.name = name;
        this.dungeons = dungeons;
        this.description = description;
        this.image_url = name.toLowerCase().replaceAll(" ", "_");
    }

    public Boss() {
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getDungeons() {
        return dungeons;
    }

    public void setDungeons(String dungeons) {
        this.dungeons = dungeons;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Bindable
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String toString() {
        return "Boss{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dungeons='" + dungeons + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
