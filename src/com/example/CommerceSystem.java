package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 사용자 입력을 처리하기 위한 scanner
    private final Scanner scanner = new Scanner(System.in);
    // 판매 중인 상품 목록
    // Main에서 생성된 List<Product>를 생성자를 통해 주입 받기
    private final List<Category> categories;

    // 생성자 (상품 정보를 담고 있는 리스트)
    // List<Product> products는 CommerceSystem 생성자를 통해 값 할당
    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    // 메서드
    // main에서 관리하던 입력/반복문 로직을 start()에서 관리
    public void start() {

        while (true) {
            printMainMenu();
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }

            if (choice < 1 || choice > categories.size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            Category selectedCategory = categories.get(choice - 1);
            runCategoryMenu(selectedCategory);
        }
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 프로그램 종료");
    }

    private void runCategoryMenu(Category category) {
        List<Product> products = category.getProducts();

        while (true) {
            System.out.println();
            System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.println((i + 1) + ". " + p.getName()
                        + " | " + p.getPrice()
                        + " | " + p.getDescription());
            }

            System.out.println("0. 뒤로가기");

            int choice = scanner.nextInt();

            if (choice == 0) {
                return; // 메인 메뉴로 복귀
            }

            if (choice < 1 || choice > products.size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            Product selected = products.get(choice - 1);

            System.out.println("선택한 상품: "
                    + selected.getName() + " | "
                    + selected.getPrice() + " | "
                    + selected.getDescription() + " | "
                    + "재고: " + selected.getStock() + "개");
        }
    }
}