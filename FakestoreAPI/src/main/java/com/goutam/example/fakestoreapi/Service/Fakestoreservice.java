package com.goutam.example.fakestoreapi.Service;

import com.goutam.example.fakestoreapi.DTO.FakestoreDTO;
import com.goutam.example.fakestoreapi.DTO.ProductRequestDTO;
import com.goutam.example.fakestoreapi.Model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Fakestoreservice implements Product_services {

  private RestTemplate restTemplate;
  public Fakestoreservice(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
  }
    @Override
    public Product getproductbyid(Long id) {
         ResponseEntity<FakestoreDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/"+id,
                 FakestoreDTO.class);
         FakestoreDTO fakestoreDTO = response.getBody();
         if(response == null || response.getBody() == null){
             return null;
         }
         return fakestoreDTO.toproduct(fakestoreDTO);
    }

    @Override
    public Product createproduct(String title, String price, String description,
                                 String image, String category) {
        ProductRequestDTO requestbody = new ProductRequestDTO();
            requestbody.setTitle(title);
            requestbody.setPrice(price);
            requestbody.setDescription(description);
            requestbody.setCategory(category);

            FakestoreDTO response = restTemplate.postForObject("https://fakestoreapi.com/products", requestbody,
                    FakestoreDTO.class);
            Product product = response.toproduct(response);

        return product;
    }

    @Override
    public Product deleteproductbyid(Long id) {

        return null;
    }

    @Override
    public List<Product> getAllproducts() {
         ResponseEntity<FakestoreDTO[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products",
                                                FakestoreDTO[].class);
         FakestoreDTO[] dtos = response.getBody();
         if(response == null || response.getBody() == null){
             return null;
         }
         List<Product> products = new ArrayList<>();
         for (FakestoreDTO dto : dtos) {
             products.add(dto.toproduct(dto));
         }
        return products;
    }
}

