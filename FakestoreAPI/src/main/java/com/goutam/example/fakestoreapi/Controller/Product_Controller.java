package com.goutam.example.fakestoreapi.Controller;

import com.goutam.example.fakestoreapi.DTO.ProductRequestDTO;
import com.goutam.example.fakestoreapi.DTO.ProductresponseDTO;
import com.goutam.example.fakestoreapi.Exception.Invalid_Input;
import com.goutam.example.fakestoreapi.Exception.ProductnotFound;
import com.goutam.example.fakestoreapi.Model.Category;
import com.goutam.example.fakestoreapi.Model.Product;
import com.goutam.example.fakestoreapi.Service.Product_services;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Product_Controller {

    private Product_services svc;
    private ProductresponseDTO productresponseDTO;

    public Product_Controller(Product_services svc,ProductresponseDTO productresponseDTO) {
        this.svc = svc;
        this.productresponseDTO = productresponseDTO;
    }


    @PostMapping("/products")
    public ProductresponseDTO createproduct(@RequestBody ProductRequestDTO dto){

        Product product = svc.createproduct(dto.getTitle(),
                dto.getPrice(),
                dto.getDescription(),
                dto.getImage(),
                dto.getCategory());

        ProductresponseDTO productresponse = productresponseDTO.converttoproduct(product);

        return productresponse;
    }

    @GetMapping("/products/{id}")
    public ProductresponseDTO getproduct(@PathVariable ("id") Long id) throws Invalid_Input, ProductnotFound {
        if(id == null){
            throw new Invalid_Input("Product id is null");
        }
        Product product = svc.getproductbyid(id);
        if(product == null){
            throw new ProductnotFound("Product not found");
        }
       ProductresponseDTO productresponse = productresponseDTO.converttoproduct(product);
       return productresponse;
    }

    @GetMapping("/products")
    public List<ProductresponseDTO> getallproduct() throws ProductnotFound {
        List<Product> products = svc.getAllproducts();
        if(products == null){
            throw new ProductnotFound("Product not found");
        }
        List<ProductresponseDTO> productresponseDTOs = new ArrayList<>();
        for (Product product : products) {
            ProductresponseDTO productresponse = productresponseDTO.converttoproduct(product);
            productresponseDTOs.add(productresponse);
        }
        return productresponseDTOs;
    }

    @DeleteMapping("/product/{id}")
    public void deleteproduct(@PathVariable("id") Long id){
        Product product = svc.getproductbyid(id);

    }

}
