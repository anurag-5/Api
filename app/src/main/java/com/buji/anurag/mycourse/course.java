package com.buji.anurag.mycourse;

public class course {
    String duration,venue,date,discription,title;
    public course(){}

    public course(String duration, String venue, String date, String discription, String title) {
        this.duration = duration;
        this.venue = venue;
        this.date = date;
        this.discription = discription;
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
