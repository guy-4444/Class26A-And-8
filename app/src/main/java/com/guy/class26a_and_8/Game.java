package com.guy.class26a_and_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Game {

    public enum GENRE {
        PUZZLE,
        ARCADE,
        RACING,
        STRATEGY,
        SIMULATION,
        SPORTS
    }

    private String id;
    private String title;
    private GENRE genre;
    private int releaseYear;
    private double rating;
    private boolean isMultiplayer;
    private ArrayList<Avatar> avatars = new ArrayList<>();
    private HashMap<String, Boolean> players = new HashMap<>();

    public Game() {}

    public String getId() {
        return id;
    }

    public Game setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Game setTitle(String title) {
        this.title = title;
        return this;
    }

    public GENRE getGenre() {
        return genre;
    }

    public Game setGenre(GENRE genre) {
        this.genre = genre;
        return this;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Game setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Game setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public boolean isMultiplayer() {
        return isMultiplayer;
    }

    public Game setMultiplayer(boolean multiplayer) {
        isMultiplayer = multiplayer;
        return this;
    }

    public ArrayList<Avatar> getAvatars() {
        return avatars;
    }

    public Game setAvatars(ArrayList<Avatar> avatars) {
        this.avatars = avatars;
        return this;
    }

    public HashMap<String, Boolean> getPlayers() {
        return players;
    }

    public Game setPlayers(HashMap<String, Boolean> players) {
        this.players = players;
        return this;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                ", isMultiplayer=" + isMultiplayer +
                ", avatars=" + avatars +
                ", players=" + players +
                '}';
    }
}
