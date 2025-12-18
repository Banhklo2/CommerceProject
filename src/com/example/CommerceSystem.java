package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 사용자 입력을 처리하기 위한 scanner
    private final Scanner scanner = new Scanner(System.in);

    // 판매 중인 상품 목록
    // Main에서 생성된 List<Product>를 주입받아 저장
    private final List<Category> categories;
    
    // 장바구니 상태를 저장/관리하는 객체
    private final Cart cart = new Cart();

    // 생성자 (상품 정보를 담고 있는 리스트)
    // Main에서 만든 카테고리 목록을 받아 시스템에 연결
    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    // ****프로그램 시작 메서드
    // main에서 관리하던 입력/반복문 로직을 start()에서 관리
    // 1~3: 카테고리 선택
    // 4~5: 주문 관리 (장바구니가 있을 때만)
    // 0: 종료
    public void start() {

        while (true) {
            printMainMenu();
            int choice = scanner.nextInt();

            // 0: 종료
            if (choice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
            
            // 4~5: 주문 관리 (장바구니가 있을 때만)
            if (choice == 4 ||  choice == 5) {
                if (cart.isEmpty()) {
                    System.out.println("장바구니가 비어있습니다."); // 장바구니가 비었을 때 에러 처리
                    continue;
                }
                if (choice == 4) {
                    runOrderConfirm();
                } else {
                    runOrderCancel();
                }
                continue;
            }

            // 카테고리 번호 검증
            if (choice < 1 || choice > categories.size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            // 선택한 카테고리로 이동
            Category selectedCategory = categories.get(choice - 1);
            runCategoryMenu(selectedCategory);
        }
    }

    // ****메인 메뉴 출력
    // 카테고리 목록 출력
    // 장바구니에 상품이 있을 때만 [주문 관리] 메뉴 추가 출력
    private void printMainMenu() {
        System.out.println();
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 프로그램 종료");

        // [주문 관리] 메뉴 추가 출력
        if (!cart.isEmpty()) {
            System.out.println();
            System.out.println("[ 주문 관리 ]");
            System.out.println("4. 장바구니 확인    | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 주문 취소    | 진행 중인 주문을 취소합니다.");
        }

        System.out.println("아래 메뉴를 선택해주세요.");
    }

    // ****카테고리 메뉴 실행
    // 해당 카테고리의 상품 목록을 출력하고 번호 입력을 받아 상품을 선택한다.
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

            // 메인으로 복귀
            if (choice == 0) {
                return;
            }

            // 상품 번호 검증
            if (choice < 1 || choice > products.size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            // 선택 상품 상세 출력
            Product selected = products.get(choice - 1);
            System.out.println("선택한 상품: "
                    + selected.getName() + " | "
                    + selected.getPrice() + " | "
                    + selected.getDescription() + " | "
                    + "재고: " + selected.getStock() + "개");
            
            // 장바구니 추가 여부 확인
            askAddToCart(selected);
        }
    }

    // ****장바구니 추가 여부 확인
    // 사용자가 "확인"을 선택하면 재고를 체크한 후 장바구니에 1개 추가한다.
    // "취소"를 선택하면 카테고리 메뉴로 돌아간다.
    private void askAddToCart(Product product) {
        System.out.println();
        System.out.println("\"" + product.getName() + " | " + product.getPrice() + " | " + product.getDescription() + "\"");
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        int input = readInt();

        if (input == 2) { return; }
        // 잘못된 입력이면 종료
        if (input != 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        // 재고 체크
        if (product.getStock() <= 0) {
            System.out.println("재고가 부족하여 장바구니에 담을 수 없습니다.");
            return;
        }

        // 장바구니에 1개 추가
        cart.add(product);
        System.out.println();
        System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
    }

    // ****(4번) 주문 확인 -> 주문 확정 처리
    // 장바구니 내역과 총 주문 금액을 출력한다.
    // 사용자가 주문 확정을 선택하면 재고를 차감하고 장바구니를 비운다.
    private void runOrderConfirm() {
        System.out.println();
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ 장바구니 내역 ]");

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            System.out.println(p.getName() + " | " + p.getPrice()
                    + " | " + p.getDescription()
                    + " | 수량: " + item.getQuantity() + "개");
        }

        // 장바구니 총액 계산
        int total = cart.getTotalPrice();

        System.out.println();
        System.out.println("[ 총 주문 금액 ]");
        System.out.println(PriceUtil.formatWon(total));

        System.out.println();
        System.out.println("1. 주문 확정      2. 메인으로 돌아가기");

        int input = readInt();
        if (input != 1) return;

        // 주문 확정 시 재고 차감 + 변경 내용 출력
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int before = p.getStock();
            int qty = item.getQuantity(); // 보통 1
            p.decreaseStock(qty);
            int after = p.getStock();
            System.out.println(p.getName() + " 재고가 " + before + "개 → " + after + "개로 업데이트되었습니다.");
        }

        // 주문 완료 후 장바구니 초기화
        cart.clear();
        System.out.println("주문이 완료되었습니다! 총 금액: " + PriceUtil.formatWon(total));
    }

    // ****(5번) 주문 취소 처리
    // 장바구니를 비우고 취소 메시지를 출력한다.
    private void runOrderCancel() {
        cart.clear();
        System.out.println("진행중인 주문을 취소했습니다.");
    }

    // Scanner 입력이 숫자가 아닐 경우 다시 입력받는다.
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.next().trim());
            } catch (NumberFormatException e) {
                System.out.print("숫자를 입력하세요: ");
            }
        }
    }
}
