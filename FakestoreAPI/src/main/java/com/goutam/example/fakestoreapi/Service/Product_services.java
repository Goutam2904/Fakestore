package com.goutam.example.fakestoreapi.Service;

import com.goutam.example.fakestoreapi.Model.Product;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;


public interface Product_services {

    public Product getproductbyid(Long id);

    public Product createproduct(String title, String price, String description,
                                 String image,  String category);

    public Product deleteproductbyid(Long id);

    public List<Product> getAllproducts();
}
