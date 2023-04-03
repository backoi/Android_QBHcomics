package com.example.qbhcomics.model;

public class Comic {
    private int cm_img;
    private String cm_chap;
    private String cm_name;

    public Comic(int cm_img, String cm_chap, String cm_name) {
        this.cm_img = cm_img;
        this.cm_chap = cm_chap;
        this.cm_name = cm_name;
    }

    public int getCm_img() {
        return cm_img;
    }

    public void setCm_img(int cm_img) {
        this.cm_img = cm_img;
    }

    public String getCm_chap() {
        return cm_chap;
    }

    public void setCm_chap(String cm_chap) {
        this.cm_chap = cm_chap;
    }

    public String getCm_name() {
        return cm_name;
    }

    public void setCm_name(String cm_name) {
        this.cm_name = cm_name;
    }
}
