package com.example.kunfish.stream.terminal.model;

public class Review {
    protected int points;
    protected String review;

    public Review(int points, String review) {
        this.points = points;
        this.review = review;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
