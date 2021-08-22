package io.javabrains.moviecatalogservice.models;

public class CatalogItem {
    private String name;
    private String desc;
    private int rating;

    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
