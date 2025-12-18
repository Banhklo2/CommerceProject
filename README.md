# 🛍️ CommerceProject

Java 콘솔 기반 **실시간 커머스 플랫폼**(카테고리 → 상품 선택) 프로젝트입니다.  
Step1~Step3로 기능을 확장하면서 **객체지향 설계(역할 분리) + 컬렉션(List) 관리 + 입력/반복/분기 흐름 제어**를 연습했습니다.

---

## ✅ 주요 기능

- **메인 메뉴(카테고리 선택) 출력**
  - 전자제품 / 의류 / 식품 등 카테고리 선택
  - `0` 입력 시 프로그램 종료
- **카테고리별 상품 목록 출력**
  - 선택한 카테고리의 상품들을 번호로 출력
  - `0` 입력 시 메인 메뉴로 돌아가기
- **상품 선택 및 상세 정보 출력**
  - 상품명 / 가격 / 설명 (Step3에서는 재고까지 확장 가능)
- **객체지향 설계 기반 데이터 관리**
  - `Product` 객체로 상품 정보를 의미 단위로 관리
  - `Category`가 `List<Product>`를 보유하여 카테고리 단위로 상품 관리
  - `CommerceSystem`이 메뉴 출력/입력/반복/분기 등 **흐름 제어 전담**
- **컬렉션 + 반복문 활용**
  - `List`로 여러 객체를 컬렉션으로 관리
  - for/for-each로 리스트 순회 출력

---

## 🧩 클래스 구성

- **Main**
  - 프로그램 시작점(Entry Point)
  - 카테고리/상품 데이터 생성 및 주입
  - `CommerceSystem.start()` 호출로 실행만 담당
- **CommerceSystem**
  - 메뉴 출력, 사용자 입력 처리, 반복/분기 등 **순서 제어(흐름) 담당**
  - Step2: `List<Product>` 주입
  - Step3: `List<Category>` 주입
- **Product**
  - 상품 데이터(이름/가격/설명/카테고리 or 재고 등) 관리
  - 필드를 `private`으로 숨기고 getter로만 조회(캡슐화)
- **Category**
  - 카테고리 이름 + 해당 카테고리의 `List<Product>` 관리
- **Customer**
  - 고객 정보 관리(확장 대비용: 이름/등급/보유정보 등)

---

## 🔒 캡슐화 적용 (Encapsulation)

- `Product`, `Category`, `Customer` 등의 데이터는 **필드를 `private`으로 선언**하여 외부에서 직접 수정할 수 없게 제한했습니다.
- 필요한 값은 **Getter 메서드로만 조회**하도록 구성하여 데이터 보호와 역할 분리를 연습했습니다.

예시 (Product):
- `private` 필드로 데이터 보호
- `getName()`, `getPrice()` 등으로만 접근
  
---

## ✅ Step별 목표 & 구현 내용

### Step 1. 기본 상품 목록 출력
- `Product` 클래스 생성 및 객체로 상품 정보 관리
- `List<Product>`에 상품 데이터 저장
- 반복문으로 상품 목록 출력
- 기본 콘솔 흐름(출력 → 입력 → 종료) 구현

---

### Step 2. CommerceSystem 도입 (Main 역할 분리)
- `CommerceSystem` 클래스 추가
- Main이 하던 **입력/반복/분기 로직을 CommerceSystem.start()로 이동**
- `products` 리스트를 **생성자로 주입**하여 데이터 전달 구조 개선

**핵심 포인트**
- “실행만 하는 Main / 로직은 System” 구조 설계

---

### ✅ Step 3. Category 도입 (상품을 카테고리 단위로 관리) + Customer 도입 (고객 정보 관리)
- `Category` 클래스 생성 → 카테고리 내부에서 `List<Product>` 관리
- `CommerceSystem`은 `List<Category>`를 관리하며 **카테고리 선택 → 상품 선택** 흐름 구현
- `Customer` 클래스 생성 → 고객 정보 객체화 기반 마련(기능 확장 대비)

**핵심 포인트**
- 책임 이동: “상품 목록 소유권”을 `CommerceSystem` → `Category`로 분리
- 역할 분리 강화: Product는 데이터 / Category는 묶음 관리 / System은 흐름 제어

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
