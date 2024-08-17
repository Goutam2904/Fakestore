package com.goutam.example.fakestoreapi.DTO;

import com.goutam.example.fakestoreapi.Model.Category;
import com.goutam.example.fakestoreapi.Model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class ProductresponseDTO {
    private Long id;
    private String Description;
    private String title;
    private String price;
    private String imageurl;
    private Category category;

    public ProductresponseDTO converttoproduct(Product product){
        ProductresponseDTO response = new ProductresponseDTO();

        response.setCategory(product.getCategory());
        response.setId(product.getId());
        response.setTitle(product.getTitle());
        response.setDescription(product.getDescription());
        response.setImageurl(product.getImage());
        response.setPrice(product.getPrice());

        return response;
    }
}
