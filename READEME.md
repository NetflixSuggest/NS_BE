# Netflix Suggestions

---

## 개발팀원

| <img src="https://avatars.githubusercontent.com/u/114637614?v=4" width=200px alt="오현두"> | <img src="https://avatars.githubusercontent.com/u/73707598?v=4" width=200px alt="유호준"> | <img src="https://avatars.githubusercontent.com/u/123963462?v=4" width=200px alt="어태규"> | <img src="https://avatars.githubusercontent.com/u/129478826?v=4" width=200px alt="윤원호"> |
| --- | --- | --- | --- |
| [오현두](https://github.com/HyunDooBoo) | [유호준](https://github.com/wns5120) | [어태규](https://github.com/EOTAEGYU) | [윤원호](https://github.com/dnjsgh1204) |

---

## 🚥목차

1. 프로젝트 소개
2. 프로젝트 설계
3. 프로젝트 개발
    1. 디렉터리 구조
    2. 데이터 활용
    3. 기능 개발
4. 테스트
    1. 트러블슈팅
5. 고찰

# 1. ⚒️프로젝트 소개

### 배경

1. Netflix Suggestions는 작품, 출연 배우, 감독 성향을 바탕으로 사용자가 원하는 영화를 손쉽게 검색할 수 있도록 설계된 프로그램
2. 사용자들의 검색 효율성을 높이고, 개인화된 추천 경험을 제공하기 위해 개발 
3. 이 프로젝트는 넷플릭스 데이터를 활용해 작품의 다양한 속성을 기준으로 상세 검색과 필터링 기능을 구현하여, 사용자 만족도를 극대화하는 데 초점을 맞춤

### 소개

Netflix Movie Data를 활용하여 JDBC(Java Database Connectivity)를 기반으로 데이터베이스와 상호 작용하는 CRUD 시스템을 개발

---

# 2. 🔎프로젝트 설계

## 2.1 시스템 아키텍처

프로젝트는 **MVC 패턴**을 기반으로 설계

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/7563ccb0-5f23-4c8a-9976-61d8a4233500/image.png)

### 구성 요소

1. **Model**:
    - 데이터베이스와 직접 상호작용하며 데이터를 처리
    - `program`, `user` 클래스와 DAO(Data Access Object) 클래스를 포함
2. **View**:
    - 사용자 인터페이스를 제공하며 콘솔 기반으로 구현
    - 사용자 입력 및 출력 처리
3. **Controller**:
    - View와 Model 간의 중간 다리 역할
    - 사용자의 요청을 처리하고 Model에서 데이터를 가져와 View에 전달

## 2.2 ERD 설계

![ERD 설계](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/fa1e10f8-2e1e-4640-9956-dfdd84b143e8/image.png)

ERD 설계

## 2.3 주요 흐름

1. 사용자는 로그인 후 역할(Admin/User)에 따라 권한을 부여 받음 
2. 관리자는 영화 데이터를 등록, 수정, 삭제 가능
3. 사용자는 영화 데이터를 검색하거나 추천 받음

---

# 3. 📀프로젝트 개발

## 3.1 📒디렉터리 구조

```bash
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/                       // 컨트롤러 계층
│   │   │   │   ├── program/
│   │   │   │   │   ├── ProgramController.java
│   │   │   │   ├── user
│   │   │   │   │   ├── UserController.java
│   │   │   ├── model/                            // 모델 계층
│   │   │   │   ├── program/
│   │   │   │   │   ├── Program.java
│   │   │   │   │   ├── ProgramDAO.java
│   │   │   │   ├── user/
│   │   │   │   │   ├── User.java
│   │   │   │   │   ├── UserDAO.java
│   │   │   │   ├── util/
│   │   │   │   │   ├── DBUtil.java
│   │   │   ├── view/                             // 뷰 계층
│   │   │   │   ├── EndView.java
│   │   │   │   ├── FailView.java
│   │   │   │   ├── StratView.java
│   ├── resources/
│   │   ├── application_db.properties           // 데이터베이스 설정
```

## 3.2 ✅ 기능

### 사용자 기능

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/3cd24b50-009d-474a-a995-fb1c99e5b9de/image.png)

- **검색 기능**
    - **제목별 검색**: 원하는 콘텐츠의 제목으로 검색 가능
    - **감독별 검색**: 감독 이름으로 콘텐츠 검색 가능
    - **나라별 검색**: 제작 국가를 기준으로 콘텐츠 검색 가능
    - **출시년도 검색**: 출시 연도를 기준으로 콘텐츠 검색 가능
    - **장르별 검색**: 장르를 기반으로 콘텐츠 검색 가능
- **전체 영화 리스트 조회**
    
    데이터베이스에 저장된 모든 영화를 조회할 수 있음
    
- **장르별 랜덤 작품 추천**
    - 특정 장르를 선택하면 랜덤으로 3개의 작품을 추천 받음

---

### 관리자 기능

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/ad8e2c34-a648-4bcf-9b42-be07b215601c/image.png)

- **영화 관리**
    - **추가**: 새로운 영화 데이터를 추가
    - **수정**: 기존 영화 데이터 업데이트
    - **삭제**: 데이터베이스에서 영화 데이터를 삭제
- **유저 관리**
    - 전체 유저 조회
    - 유저 계정 삭제

## 3.3 🏃‍♂️데이터 활용

### 1. [Kaggle] Neflix Movie and Tv shows use data

https://www.kaggle.com/datasets/shivamb/netflix-shows

### 2. **사용한 데이터 컬럼**

- `show_id` , `type` , `title`, `director`, `country`, `release_year`, `duration` , `listed_in`, `description`

### 3. duration 컬럼 숫자화 및 특정 컬럼 한국어 번역

- `duration` 컬럼에서 "min" 문자열을 제거하고, 정수형(int) 데이터로 변환
- `country`(제작 국가)와 `listed_in`(장르) 컬럼의 값을 한국어로 번역
- 번역은 Python의 `googletrans` 라이브러리를 사용하여 수행

### 4. 데이터 예시

| show_id | type | title | director | country_translated | release_year | duration | listed_in_translated | description |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 12345 | Movie | 서울의 봄 | 김성수 | 대한민국 | 2023 | 120 | 드라마, 역사 | 1980년대 서울의 민주화 운동을 배경으로.. |

---

# 4. 📐테스트

## 4.1 사용자 테스트

### **회원가입**

![회원가입.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/e2c50acc-5b4a-4110-b52e-a9383edafb59/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.png)

### 로그인

![로그인.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/7fa61670-3e9e-4bb6-ab5e-0058fb65d6d8/%EB%A1%9C%EA%B7%B8%EC%9D%B8.png)

### 제목 검색

![제목 검색.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/fac2baa2-ed9f-4be1-aee2-8cb42eadee52/%EC%A0%9C%EB%AA%A9_%EA%B2%80%EC%83%89.png)

### 장르별 랜덤 추천

![액션 추천.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/d1a099fe-d6b1-4a4c-8c52-51d50ba2da9d/%EC%95%A1%EC%85%98_%EC%B6%94%EC%B2%9C.png)

## 4.2 관리자 테스트

### 관리자 기능

![관리자 기능.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/12171dce-457d-4a76-8c4e-9b0969346943/%EA%B4%80%EB%A6%AC%EC%9E%90_%EA%B8%B0%EB%8A%A5.png)

### 영화 추가

![영화 추가.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/fd1e269a-d109-44dc-ab00-119167b58ac1/%EC%98%81%ED%99%94_%EC%B6%94%EA%B0%80.png)

![db에 영화 추가.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/250f745a-f4f8-439f-bcfd-a85ec29cf16e/06aea3bb-cb0f-43bb-8c86-5acd0d67ace2/db%EC%97%90_%EC%98%81%ED%99%94_%EC%B6%94%EA%B0%80.png)

## 4.3 트러블슈팅

## 문제 정의

JDBC로 SQL문을 작성하는 중 Like 문을  작성하는 방법에 대한 이슈 & 실행 시 문법 오류 발생 

```java
con.prepareStatement("select * from netflix_movies where listed_in like %?%");
```

### ERROR!!

구글링을 통해 다른 방식 시도 

```java
con.prepareStatement("select * from netflix_movies where listed_in like '%' || ? || '%'");
```

### ERROR!!

## 해결 방법

```java
con.prepareStatement("select * from netflix_movies where listed_in like '%' ? '%'");
```

올바른 SQL 문  (MySQL 과 Oracle 을 착각하여 발생한 문제)

## 🎈 DBMS 종류 별 Like문 올바른 사용 방법

### Oracle

```sql
con.prepareStatement("select * from netflix_movies where listed_in like '%' || ? || '%'");
```

### MySQL

```sql
con.prepareStatement("select * from netflix_movies where listed_in like '%' ? '%'");
```

# 5. 📜고찰

- 코드 리팩토링
- 기능 / 뷰 보완
- 드라마 및 최신 정보 검색 기능 추가
