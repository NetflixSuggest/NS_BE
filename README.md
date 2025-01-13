# Netflix Suggestions

## 개발팀원

| <img src="https://avatars.githubusercontent.com/u/114637614?v=4" width=200px alt="오현두"> | <img src="https://avatars.githubusercontent.com/u/73707598?v=4" width=200px alt="유호준"> | <img src="https://avatars.githubusercontent.com/u/123963462?v=4" width=200px alt="어태규"> | <img src="https://avatars.githubusercontent.com/u/129478826?v=4" width=200px alt="윤원호"> |
| --- | --- | --- | --- |
| [오현두](https://github.com/HyunDooBoo) | [유호준](https://github.com/wns5120) | [어태규](https://github.com/EOTAEGYU) | [윤원호](https://github.com/UnoYoon/UnoYoon) |


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

![image](https://github.com/user-attachments/assets/aa478334-1e01-469c-96b4-7dc03b93ae2f)


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

![image](https://github.com/user-attachments/assets/7f722515-25ee-49b6-85ed-ff494a6cbcae)



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

![image](https://github.com/user-attachments/assets/31d5517a-c0e1-4c07-9330-9155c484c80d)


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

![image](https://github.com/user-attachments/assets/6411d5b8-c456-4e9d-8040-ba51d19fd1f8)


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

![회원가입](https://github.com/user-attachments/assets/021a7ca6-2e3d-4311-870d-8fb9be2ed14f)


### 로그인

![로그인](https://github.com/user-attachments/assets/5d677e57-afa2-427e-aff4-727f1a59c854)


### 제목 검색

![제목 검색](https://github.com/user-attachments/assets/cd8f52a7-bb54-450e-9f09-1bbf9e13fb5c)


### 장르별 랜덤 추천

![액션 추천](https://github.com/user-attachments/assets/52bf1ea2-ceb8-4764-8e2f-b1c8391f56c3)


## 4.2 관리자 테스트

### 관리자 기능

![관리자 기능](https://github.com/user-attachments/assets/edfa15bd-84af-49e8-90ea-997374705b92)


### 영화 추가

![영화 추가](https://github.com/user-attachments/assets/b09c321a-ed1c-4979-a3e1-053d83ee1c11)


![db에 영화 추가](https://github.com/user-attachments/assets/388861e9-d2e4-4983-b4d2-f3077a048b9a)


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
