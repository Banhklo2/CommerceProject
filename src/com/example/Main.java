package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // Product 객체들을 담기 위한 리스트 생성
        List<Product> products = new ArrayList<>();

        // 상품 정보 객체 생성 후 리스트에 추가
        products.add(new Product("Galaxy S25", "1,200,000원", "최신 안드로이드 스마트폰", "1"));
        products.add(new Product("iPhone 16", "1,350,000원", "Apple의 최신 스마트폰", "2"));
        products.add(new Product("MacBook Pro", "2,400,000원", "M3 칩셋이 탑재된 노트북", "3"));
        products.add(new Product("AirPods Pro", "350,000원", "노이즈 캔슬링 무선 이어폰", "4"));

        // CommerceSystem 객체 생성 (생성자로 products 전달)
        CommerceSystem commerceSystem = new CommerceSystem(products);

        // main이 하던 반복/입력 로직은 start()로 이동
        commerceSystem.start();

        // 종료 시 자원 해제
        scanner.close();
    }
}
