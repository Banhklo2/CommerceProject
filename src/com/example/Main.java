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


        // 사용자가 종료를 선택할 때까지 반복 실행
        while(true){

            // 메뉴 제목 출력
            System.out.println("\n[실시간 커머스 플랫폼 - 전자제품]");

            // 리스트에 담김 모든 상품 정보를 출력
            for (Product p : products) {
                System.out.println(
                        p.getProductCategory() + ". " +
                        p.getProductName() + " | " +
                        p.getProductPrice() + " | " +
                        p.getProductDescription()
                );
            }
            // 종료 메뉴 출력
            System.out.println("0. 종료 프로그램 종료");

            // 사용자로부터 메뉴 번호 입력받기
            int num = scanner.nextInt();

            // 0번 입력 시 프로그램 종료
            if (num == 0){
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
            // 유효하지 않은 번호 입력 시 예외 처리
            if (num < 0 || num > products.size()){
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            // 사용자가 선택한 번호에 해당하는 상품 번호 가져오기
            // (리스트 인덱스는 0부터 시작하므로 num -1)
            Product selected = products.get(num - 1);
            System.out.println("선택한 상품: " + selected.getProductCategory());
        }
    }
}
