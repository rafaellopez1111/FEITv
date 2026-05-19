/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rafae
 */
public class Video {
    private String video_name;
    private String release_date;
    private int like_amount = 0;
    private int dislike_amount = 0;
    private String description;

    public Video(String video_name, String release_date, String description) {
        this.video_name = video_name;
        this.release_date = release_date;
        this.description = description;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getLike_amount() {
        return like_amount;
    }

    public void setLike_amount(int like_amount) {
        this.like_amount = like_amount;
    }

    public int getDislike_amount() {
        return dislike_amount;
    }

    public void setDislike_amount(int dislike_amount) {
        this.dislike_amount = dislike_amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
