package com.example.userservicev4;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.UUID;

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
    private String userId;


    public User() {
        userId = UUID.randomUUID().toString();
    }

    public User(String userName, String imgUrl) {
        this.userName = userName;
        this.imgUrl = imgUrl;
        userId = UUID.randomUUID().toString();
    }

}
