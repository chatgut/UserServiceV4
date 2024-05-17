package com.example.userservicev4;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String imgUrl;


    public User() {
    }

    public User(String userName, String userId, String imgUrl) {
        this.userName = userName;
        this.imgUrl = imgUrl;
    }

}
