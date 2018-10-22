package com.harsh.bench;

public class User {
    private String Score;
    private String Time;

    public User(String Score, String Time) {
        this.Score = Score;
        this.Time = Time;
    }

    public String getScore() {
        return Score;
    }

    public String getTime() {
        return Time;
    }
}
