# 프로젝트 명
Todolist 만들기

# 프로젝트 소개
React.js, 스프링 부트, AWS로 배우는 웹 개발 101 책을 참고해 리엑트, 스프링 부트, AWS의 개요를 이해하는 것을 목표로 하고 있습니다.

# 설치 방법
```bash
git clone https://github.com/wonchanLee-tech/to_dolist.git
```

# 사용 예제


# 개발 환경
Ubuntu 20.04.4 LTS

# 변경 사항

22.03.03 - lombok test file (DemoModel.java)

22.03.06 - Entity, Model, DTO 구현 완료 (TodoEntity.java, TodoDTO.java, ResponseDTO.java)

22.03.07 - TestController 구현 완료 (TestController.java)

22.03.08 - TestController에서 매개변수 넘겨받는 테스트 메서드 구현 (Testcontorller.java, TestRequestBodyDTO.java)

22.03.09 - Service Layer 구현 완료 (TodoService.java, TodoController.java)

22.03.10 - Persistence Layer - DB Table - Entity ORM 작업 중 (TodoEntity.java)

22.03.11 - Persistence Layer - DB Table - Entity ORM 구현 완료 (TodoRepository.java, TodoEntity.java, TodoService.java)

22.03.12 - Persistence Layer - DB에 쿼리를 보내는 메서드 테스트 구현 및 서비스 레이어 로깅 세팅 완료 (TodoRepository.java, TodoService.java)

22.03.14 - Create, Retrieve API 구현 - POST 메서드로 보낸 JSON 형태의 DTO → Entity 변환을 통해 DB에 저장하는 create API와 GET 메서드로 저장한 Entity → DTO 변환을 통해 JSON 형태로 리턴하는 Retrieve API를 구현했다 (TodoController.java, TodoDTO.java, TodoService.java)

22.03.15 - Update, Delete API 구현 - PUT 메서드로 DB에 있는 Entity를 수정하고 다시 저장하는 update API와 DELETE 메서드로 저장한 Entity를 삭제하는 delete API를 구현했다. (TodoService.java, TodoController.java)

22.03.16 - Node.js - React 라이브러리 다운로드 완료 (test-project 디렉터리 아래)

22.03.17 - material-ui 패키지 설치.

22.03.19 - state, prop를 이용해 Item 매개변수를 받아 Todo item을 렌더링 테스트 작업 완료. (Todo.js, App.js)

22.03.20 - material-ui로 UI 만들고 AddTodo 컴포넌트의 state.item에 inputField에 적인 문자열을 임시로 저장하는 기능 구현 완료 (AddTodo.js, App.js, Todo.js)

22.03.21 - App 컴포넌트의 items에 item을 추가하는 add 함수를 AddTodo 컴포넌트의 props로 전달해 Todo item을 추가하는 기능을 구현했습니다. (AddTodo.js, App.js)

22.03.22 - App 컴포넌트의 items에 item을 삭제하는 delete 함수를 Todo.js 컴포넌트의 props로 전달해 Todo item을 삭제하는 기능을 구현했습니다. (Todo.js, App.js)

22.03.23 - ItemBase의 readOnly props를 변경하고 이벤트 핸들러 함수를 통해 Todo item을 수정하는 함수를 구현했습니다. (Todo.js)

22.03.27 - api-config, ApiService를 이용해 fetch를 통해 백엔드 서버에서 API를 호출해 프론트엔드 애플리케이션과 HTTP로 연결시켰다. local 환경에서는 완벽하게 동작하는 애플리케이션을 구현한 셈이다. (api-config.js, ApiService.js, App.js, Todo.js)

22.03.31 - User 레이어를 구현했다. User persistence, Sevice, Controllder 레이어를 구현하고 데이터 교환에 필요한 Entity, DTO를 구현해 회원 가입, 로그인이 잘 수행됨을 확인했다. (UserControllder.java, UserDTO.java, UserEntity.java, UserRepository.java, UserService.java)

22.04.01 - security 패키지 아래 token을 발행하는 TokenProvider 클래스를 구현했다. 이 클래스는 jjwt 라이브러리를 사용하고, UserEntity를 받아 JWT 토큰을 생성하는 create 메서드, {헤더}.{페이로드}를 서명한 후 token의 서명과 비교하고 유효성 검사를 해서 userId를 리턴하는 validateAndGetUserId 메서드를 제공한다.(UserController.java, TokenProvider.java)