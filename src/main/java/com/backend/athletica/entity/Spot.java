package com.backend.athletica.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spot")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "spot_id")
    private List<Review> reviews;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "spot_id")
    private List<Slot> slots;

    public Spot() {}

    public Spot(Long id, String name, String lat, String lon, String description, List<Review> reviews, List<Slot> slots) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.reviews = reviews;
        this.slots = slots;
    }

    public Spot(String name, String lat, String lon, String description, List<Review> reviews, List<Slot> slots) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.reviews = reviews;
        this.slots = slots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
