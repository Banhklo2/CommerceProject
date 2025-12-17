# 🛍️ CommerceProject

**Java 콘솔 기반 실시간 커머스 플랫폼(전자제품) 상품 관리 프로젝트**  
Step1에서 객체(Product) 설계 + List 컬렉션 관리 + 반복문 출력 + 입력 분기 처리를 연습했습니다.

---

## ✅ 주요 기능

- 전자제품 상품 목록 출력
- 사용자 메뉴 번호 입력 (0 입력 시 프로그램 종료)
- Product 클래스로 상품 정보를 객체로 관리
- List<Product>로 여러 상품을 컬렉션으로 관리
- 향상된 for문(for-each)으로 상품 목록 순회 출력

---

## 🧩 클래스 구성

- **Product** : 상품 정보(이름/가격/설명 등) 관리
- **Category** : 카테고리 단위로 `Product` 목록 관리
- **Customer** : 고객 정보 관리
- **CommerceSystem** : 상품 관리 + 사용자 입력/반복 로직을 `Main`에서 분리  
  - `products` 리스트를 **생성자로 주입**(의존성 주입 연습)

---

---

## 🧩 Step별 목표 & 구현 내용

### ✅ Step 1. 기본 상품 목록 출력 (그대로 유지)
- `Product` 클래스 생성
- `List<Product>`에 상품 데이터 저장
- 반복문으로 상품 목록 출력
- (기본 콘솔 흐름) 출력 → 입력 → 종료

---

### ✅ Step 2. CommerceSystem 도입 (Main 역할 분리)
- `CommerceSystem` 클래스 추가
- 상품 관리 및 사용자 입력/반복 로직을 **Main에서 분리**
- `products` 리스트를 **생성자로 주입**하여 데이터 전달 구조 개선

**핵심 포인트**
- Main 비대화 방지
- “실행만 하는 Main / 로직은 System” 구조 연습

---

### ✅ Step 3. Category 도입 (상품을 카테고리 단위로 관리), Customer 도입 (고객 정보 관리)
- `Category` 클래스 생성
- 카테고리 내부에서 `List<Product>`로 **상품 목록 관리**
- “상품 목록 전체” → “카테고리별 상품 목록” 구조로 확장 가능

**핵심 포인트**
- List + 반복문으로 “상품 목록 관리 구조” 만들기
- 역할 분리 (Product는 데이터, Category는 묶음/관리)

### ✅ Step 3. Customer 도입 (고객 정보 관리)
- `Customer` 클래스 생성
- 고객 정보(예: 이름/보유금액/장바구니/구매내역 등)를 객체로 관리할 수 있는 기반 마련

**핵심 포인트**
- 앞으로 “구매/결제/포인트” 같은 기능 확장 준비
- 사용자(고객) 데이터를 구조화하는 연습

---

## 🗂️ 프로젝트 구조

```text
CommerceProject/
 ├─ src/
 │ └─ com/example/commerce/
 │ ├─ Main.java
 │ ├─ CommerceSystem.java
 │ ├─ Product.java
 │ ├─ Category.java
 │ └─ Customer.java
 └─ README.md
