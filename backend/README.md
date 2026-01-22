# Backend

## ☑️ Architecture Overview
- Controller – Service – Repository 계층 분리 구조(Layered Architecture)를 기반으로 구현
- 각 계층의 역할 명확히 분리하여 유지보수성, 확장성, 테스트 용이성 확보하는 것 목표로 구현
- Controller → Service → Repository → Database
  - DTO는 Controller와 Service 사이에서 API 요청/응답 전용으로 사용
  
## ☑️ Tech Stack
- Java 21
- Spring Boot 3.5.7
- Spring Web (REST API)
- Spring Data JPA
- MySQL 
- Docker


## ☑️ Package Structure
- com.example.todo 폴더 구조:
  - config: WebConfig (CORS 설정)
  - controller: TodoController (HTTP 요청/응답 처리)
  - dto: UpdateTodoDto (API 요청/응답 전용 객체)
  - entity: Todo (DB 엔티티)
  - repository: TodoRepository (DB 접근 계층)
  - service: TodoService (비즈니스 로직 담당)



## ☑️ Layer Responsibilities
### 1. controller / TodoController
- HTTP 요청/응답을 담당하는 게층
  - 클라이언트로부터 요청을 수신
  - 요청 데이터를 DTO로 매핑
  - 비즈니스 로직은 직접 처리하지 않고 Service 계층에 위임
  - REST API 엔드포인트 정의 (/todos)

### 2. service / TodoService
- 비즈니스 로직을 담당하는 핵심 계층
  - Todo 생성, 수정, 삭제, 업데이트 로직 처리
  - Repository를 통해 데이터 접근
  - Controller와 Repository 사이의 중간 조율자 역할

### 3. repository / TodoRepository
- DB 접근 계층
  - Spring Data JPA를 사용하여 CRUD 처리
  - SQL을 직접 작성하지 않고 인터페이스 기반으로 데이터 접근

### 4. entity / Todo
- 도메인의 핵심 객체
  - Todo의 상태와 속성을 표현
  - DB테이블과 1:1 매칭
  - 비즈니스 규칙의 중심이 되는 객체

### 5. dto / UpdateTodoDto
- API 요청/응답 전용 객체
  - Entity와 API 요청 바디를 분리
  - 필요한 필드만 선택적으로 수신

### 6. config / WebConfig
- 프론트엔드와 백엔드 간 통신을 위한 CORS 정책 설정


## ☑️ API Endpoints
- GET
  - /todos
  - Todo 목록 조회
- POST
  - /todos
  - Todo 생성
- DELETE
  - /todos/{id}
  - Todo 삭제
- PUT
  - /todos/{id}
  - Todo 수정