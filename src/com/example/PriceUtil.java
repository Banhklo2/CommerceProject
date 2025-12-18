package com.example;

import java.text.DecimalFormat;

// 가격 변환을 전담하는 클래스 (계산 가능하게 하기 위해)
public class PriceUtil {

    // 문자열 형태의 가격을 계산 가능한 정수로 변환
    public static int parseWon(String price){
        // "135,000원 -> 135000
        String digits = price.replace("원", "").replace(",", "").trim();
        return Integer.parseInt(digits);
    }

    // 숫자 형태의 가격을 문자열 가격으로 변환
    public static String formatWon(int amount) {
        // 135000 -> 135,000원
        return new DecimalFormat("#,###").format(amount) + "원";
    }
}
