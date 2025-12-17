package com.example;

public class Product {

    //1.속성
    private final String name; // 상품 이름
    private final String price; // 상품 가격
    private final String description; // 상품 설명
    private final int stock;

    //2.생성자
    // Product 객체를 생성할 때 상품 정보를 한 번에 초기화
    public Product(String name, String price, String description, int stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    //3.메서드
    // private 필드에 직접 접근하지 않고 값을 꺼내기 위한 메서드들
    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }
}
