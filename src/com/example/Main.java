package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 카테고리 생성
        Category electronics = new Category("전자제품");
        Category clothes = new Category("의류");
        Category food = new Category("식품");

        // 카테고리 목록(List<Category>) 생성
        List<Category> categories = new ArrayList<>();
        categories.add(electronics);
        categories.add(clothes);
        categories.add(food);

        // 전자제품 상품 추가
        electronics.addProduct(new Product("Galaxy S25", "1,200,000원", "최신 안드로이드 스마트폰", 50));
        electronics.addProduct(new Product("iPhone 16", "1,350,000원", "Apple의 최신 스마트폰", 30));
        electronics.addProduct(new Product("MacBook Pro", "2,400,000원", "M3 칩셋이 탑재된 노트북", 10));
        electronics.addProduct(new Product("AirPods Pro", "350,000원", "노이즈 캔슬링 무선 이어폰", 100));

        CommerceSystem commerceSystem = new CommerceSystem(categories);

        // main이 하던 반복/입력 로직은 start()로 이동
        commerceSystem.start();
    }
}
