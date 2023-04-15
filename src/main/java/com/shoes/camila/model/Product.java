package com.shoes.camila.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String price;

    public Product(String name, String description, String imageUrl, String price) {
    }
}
