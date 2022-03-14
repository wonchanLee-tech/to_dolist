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

22.03.14 - Create, Retrieve API 구현 - POST 메서드로 보낸 JSON 형태의 DTO → Entity 변환을 통해 DB에 저장하는 create 메서드와 GET 메서드로 저장한 Entity → DTO 변환을 통해 JSON 형태로 리턴하는 Retrieve API를 구현했다 (TodoController.java, TodoDTO.java, TodoRepository.java, TodoService.java)