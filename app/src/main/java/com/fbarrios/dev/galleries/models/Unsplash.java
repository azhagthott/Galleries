package com.fbarrios.dev.galleries.models;

public class Unsplash {
    private UnsplashUrls urls;
    private String color;
    private int downloads;
    private int width;
    private boolean liked_by_user;
    private UnsplashUser user;
    private int height;
    private int likes;

    public Unsplash() {
    }

    public Unsplash(UnsplashUrls urls, UnsplashUser user) {
        this.urls = urls;
        this.user = user;
    }

    public Unsplash(UnsplashUrls urls, String color, UnsplashUser user) {
        this.urls = urls;
        this.color = color;
        this.user = user;
    }

    public UnsplashUrls getUrls() {
        return this.urls;
    }

    public void setUrls(UnsplashUrls urls) {
        this.urls = urls;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDownloads() {
        return this.downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean getLiked_by_user() {
        return this.liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public UnsplashUser getUser() {
        return this.user;
    }

    public void setUser(UnsplashUser user) {
        this.user = user;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
