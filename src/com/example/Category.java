package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category {

    private final String categoryName;
    private final List<Product> products = new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    // 카테고리 이름 반환
    public String getCategoryName() { return categoryName; }

    // 상품 추가
    public void addProduct(Product product) {
        products.add(product);
    }

    // 상품 목록 반환
    public List<Product> getProducts() {
        return List.copyOf(products);
    }
}
