package com.example.jwtspring3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
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
    private String avatar;
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

}
