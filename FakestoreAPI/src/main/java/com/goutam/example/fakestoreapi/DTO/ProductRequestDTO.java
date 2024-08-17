package com.goutam.example.fakestoreapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    String title;
    String price;
    String description;
    String image;
    String category;
}
