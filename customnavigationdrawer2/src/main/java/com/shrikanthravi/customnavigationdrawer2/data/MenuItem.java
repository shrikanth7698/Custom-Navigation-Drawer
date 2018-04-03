package com.shrikanthravi.customnavigationdrawer2.data;


public class MenuItem {
    String title;
    int imageId;
    boolean selected;

    public MenuItem(String title, int imageId, boolean selected) {
        this.title = title;
        this.imageId = imageId;
        this.selected = selected;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}


