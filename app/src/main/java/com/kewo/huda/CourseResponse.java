package com.kewo.huda;



import java.io.Serializable;

public class CourseResponse implements Serializable {

    private int id;
    private String category;
    private String title;
    private String description;
    private String duration;
    private String cost;
    private String assessment;
    private String certification;
    private String responsive;
    private String publisher;
    private String url;
    private String web_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getResponsive() {
        return responsive;
    }

    public void setResponsive(String responsive) {
        this.responsive = responsive;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    @Override
    public String toString() {
        return "CourseResponse{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", cost='" + cost + '\'' +
                ", assessment='" + assessment + '\'' +
                ", certification='" + certification + '\'' +
                ", responsive='" + responsive + '\'' +
                ", publisher='" + publisher + '\'' +
                ", url='" + url + '\'' +
                ", web_url='" + web_url + '\'' +
                '}';
    }
}

