package com.example;

import java.util.List;
import java.util.ArrayList;

public class Cart {

    // 장바구니에 담긴 모든 항목(CartItems) 목록
    private final List<CartItem> items = new ArrayList<>();

    // 장바구니가 비어 있는지 여부를 반환한다.
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // 장바구니에 담긴 상품 목록을 반환한다.
    public List<CartItem> getItems() {
        return items;
    }

    // 장바구니에 담긴 모든 상품의 총 금액을 계산한다.
    // 각 상품의 금액 계산은 CartItem에서 처리한다.
    public int getTotalPrice() {
        int sum = 0;
        for (CartItem item : items) {
            sum += item.getLineTotal(); // CartItem에 있는 줄금액 메서드 사용
        }
        return sum;
    }

    // 장바구니에 상품을 추가한다.
    public void add(Product product) {
        CartItem existing = findItem(product);

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + 1);
        } else {
            items.add(new CartItem(product, 1));
        }
    }

    // 주문 완료 또는 주문 취소 시 장바구니를 비운다.
    public void clear() {
        items.clear();
    }

    // 장바구니에 이미 담긴 상품인지 확인한다.
    private CartItem findItem(Product product) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) return item;
        }
        return null;
    }
}
