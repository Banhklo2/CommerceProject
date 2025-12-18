package com.example;

public class CartItem {

    // 장바구니에 담긴 상품
    private final Product product;
    // 해당 상품의 수량
    private int quantity;

    // 생성자
    public CartItem(Product product, int quantity) {
        this.product = product; // 장바구니에 담길 상품
        this.quantity = quantity; // 담긴 상품의 수량
    }

    // 장바구니에 담긴 상품 정보를 반환
    public Product getProduct() {
        return this.product;
    }

    // 장바구니에 담긴 상품의 수량 반환
    public int getQuantity() {
        return this.quantity;
    }

    // 장바구니에 담긴 상품의 수량 변경 (장바구니에 동일 상품을 추가할 때)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // 장바구니에 담긴 상품의 총액 계산
    public int getLineTotal() {
        return PriceUtil.parseWon(product.getPrice()) * quantity;
    }
}
