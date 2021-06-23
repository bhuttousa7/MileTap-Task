package com.example.taskmiletap.Pojos;

public class Category {
    int id;
    int url;
    String catogary_Name;

    public Category(int id, String catogary_Name, int url) {
        this.id = id;
        this.catogary_Name = catogary_Name;
        this.url = url;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatogary_Name() {
        return catogary_Name;
    }

    public void setCatogary_Name(String catogary_Name) {
        this.catogary_Name = catogary_Name;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

}
