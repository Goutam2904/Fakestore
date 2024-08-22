package com.goutam.example.fakestoreapi.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity

public class Product extends BaseModel implements Serializable {

    private String title;
    private String description;
    private String price;
    private String image;

    private Category category;


}
