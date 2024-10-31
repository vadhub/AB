package com.backend.athletica.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Long id;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date_created")
    private Date dateCreated;

    public Review() {
    }

    public Review(Long id, int rating, String comment, Date dateCreated) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.dateCreated = dateCreated;
    }

    public Review(int rating, String comment, Date dateCreated) {
        this.rating = rating;
        this.comment = comment;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
