package com.example.jwtspring3.model;

import jakarta.persistence.*;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    private Long bedroom;
    private Long bathroom;
    private Long livingRoom;
    private Long kitchen;
    private Long successRental;
    @Column(length = 1000)
    private String information;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Location location;
    @ManyToOne
    private User user;

    public Property() {
        this.successRental = 0L;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getBedroom() {
        return bedroom;
    }

    public void setBedroom(Long bedroom) {
        this.bedroom = bedroom;
    }

    public Long getBathroom() {
        return bathroom;
    }

    public void setBathroom(Long bathroom) {
        this.bathroom = bathroom;
    }

    public Long getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(Long livingRoom) {
        this.livingRoom = livingRoom;
    }

    public Long getKitchen() {
        return kitchen;
    }

    public void setKitchen(Long kitchen) {
        this.kitchen = kitchen;
    }

    public Long getSuccessRental() {
        return successRental;
    }

    public void setSuccessRental(Long successRental) {
        this.successRental = successRental;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
