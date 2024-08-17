package com.goutam.example.fakestoreapi.DTO;

import com.goutam.example.fakestoreapi.Model.Category;
import com.goutam.example.fakestoreapi.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreDTO {
    private Long id;
    private String title;
    private String Description;
    private String image;
    private String price;
    private String category;

    public Product toproduct(FakestoreDTO fakestoreDTO){

        Product product = new Product();

        Category category = new Category();
        category.setTitle(fakestoreDTO.getCategory());

        product.setCategory(category);
        product.setId(fakestoreDTO.getId());
        product.setTitle(fakestoreDTO.getTitle());
        product.setDescription(fakestoreDTO.getDescription());
        product.setImage(fakestoreDTO.getImage());
        product.setPrice(fakestoreDTO.getPrice());

        return product;



    }
}
