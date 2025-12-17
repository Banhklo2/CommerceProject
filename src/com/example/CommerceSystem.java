package com.example;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 사용자 입력을 처리하기 위한 scanner
    private final Scanner scanner = new Scanner(System.in);
    // 판매 중인 상품 목록
    // Main에서 생성된 List<Product>를 생성자를 통해 주입 받기
    private final List<Product> products;

    // 생성자 (상품 정보를 담고 있는 리스트)
    // List<Product> products는 CommerceSystem 생성자를 통해 값 할당
    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    // 메서드
    // main에서 관리하던 입력/반복문 로직을 start()에서 관리
    public void start() {

        while(true){

            // 메뉴 제목 출력
            System.out.println("\n[실시간 커머스 플랫폼 - 전자제품]");

            // 상품 목록 출력
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

            // 0 입력 시 프로그램 종료
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

            // 선택 결과 출력
            System.out.println("선택한 상품: " + selected.getProductCategory());
        }
    }
}
