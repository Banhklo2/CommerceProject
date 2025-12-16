package com.example;

public class Product {

    //1.속성
    private String productName; // 상품 이름
    private String productPrice; // 상품 가격
    private String productDescription; // 상품 설명
    private String productCategory; // 상품 번호

    //2.생성자
    // Product 객체를 생성할 때 상품 정보를 한 번에 초기화
    public Product(String productName, String productPrice, String productDescription, String productCategory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

    //3.메서드
    // private 필드에 직접 접근하지 않고 값을 꺼내기 위한 메서드들
    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }
}
