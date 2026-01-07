package com.guy.class26a_and_8;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String id;
    private String name;
    private String email;
    private HashMap<String, Boolean> gameIds = new HashMap<>();

    public User() {}

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public HashMap<String, Boolean> getGameIds() {
        return gameIds;
    }

    public User setGameIds(HashMap<String, Boolean> gameIds) {
        this.gameIds = gameIds;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
