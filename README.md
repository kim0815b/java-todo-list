# java-todo-list

## 공통 프로그래밍 요구사항
1. 코드의 가독성과 유지보수성을 높이기 위해 클래스와 메소드를 분리하여 개발합니다.
2. 예외 처리를 통해 오류를 방지합니다.
3. 변수, 메소드, 클래스 등 작절한 네이밍을 통해 코드의 목적을 명확히 전달합니다.

## 1 단계
**기본적인 할 일 목록 애플리케이션 개발**

[요구사항]
1. 프로그램 옵션 및 종료
   - 프로그램을 실행하면 사용자에게 "옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료" 라는 메시지를 보여줍니다.
   - 사용자가 1, 2, 3, 4를 입력하여 해당 기능을 실행합니다.
   - 4를 입력하면 "프로그램을 종료합니다."라고 출력하고 프로그램을 종료합니다.
   - 사용자가 잘못된 값을 입력하면 "잘못된 입력입니다."라는 메시지를 출력 후, 다시 옵션을 선택하도록 합니다.

2. 할 일 추가
   - 사용자가 할 일을 입력하면, 해당 정보를 저장됩니다. 각 할 일은 자동으로 고유 번호(ID)를 받게 됩니다. 
     - 이 번호는 1부터 시작하여 새로운 할 일이 추가될 때마다 순서대로 증가합니다.
   - 할 일을 추가하면 "할 일이 추가되었습니다. ID: [할 일의 고유 번호]" 를 출력합니다.


3. 할 일 삭제
   - 사용자는 삭제하고 싶은 할 일의 고유 번호(ID)를 입력합니다.
   - 해당 번호의 할 일이 존재하면, 해당 할 일을 삭제하고 "할 일이 삭제되었습니다. ID: [삭제된 할 일의 고유 번호]"를 출력합니다.
   - 입력한 번호에 해당하는 할 일이 없으면 "해당 ID의 할 일이 없습니다."라고 알립니다.

4. 할 일 조회
   - 사용자는 조회하고자 하는 할 일의 고유 번호(ID)를 입력합니다.
   - 해당 번호의 할 일이 존재하면, "할 일 ID: [조회된 할 일의 고유 번호] 내용: [할 일의 설명]"를 출력 합니다.
   - 입력한 번호에 해당하는 할 일이 없으면 "해당 ID의 할 일이 없습니다."를 출력합니다.

- 힌트
   - HashMap 자료구조를 활용합니다. 



## 2 단계

- **클래스 분리**
  - 클래스를 분리하는 주된 이유는 코드의 응집성을 높이고 결합도를 낮추기 위함입니다.
  - 응집성이 높은 코드는 관련된 기능이 하나의 클래스 내에 모여 있어 유지보수가 쉽고, 결합도가 낮은 코드는 다른 부분의 변경이 이 클래스에 미치는 영향이 적어 다른 코드와의 의존성이 줄어듭니다.
  - 이렇게 함으로써 코드의 재사용성을 높이고, 각 부분을 독립적으로 개발하고 테스트할 수 있습니다.

- **Single Responsibility Principle (SRP)**
  - 객체지향 소프트웨어 설계의 SOLID 원칙 중 하나로, "하나의 클래스는 하나의 책임만을 가져야 한다"라고 정의됩니다. 이 원칙은 응집도와 결합도에 직접적인 영향을 미치며, 소프트웨어의 설계 품질을 향상시키는 데 핵심적인 역할을 합니다.
  - 유지보수성: 한 클래스가 하나의 책임만을 갖도록 설계하면, 그 책임에 대한 변경이 필요할 때 해당 클래스만 수정하면 됩니다. 이는 예상치 못한 부작용을 줄이고, 코드의 유지보수를 용이하게 합니다.
  - 이해 및 관리 용이성: 클래스가 단일 책임을 갖는다면, 그 클래스의 기능을 이해하고 관리하기가 훨씬 쉽습니다. 코드의 복잡성이 낮아지며, 새로운 개발자가 코드베이스에 적응하는 시간도 단축됩니다.
  - 테스트 용이성: 단일 책임을 가진 클래스는 테스트하기가 더 쉽습니다. 각 클래스가 명확한 목적을 가지고 있으므로, 그 목적에 맞는 테스트 케이스를 작성하고 실행하기가 간단해집니다.


[요구사항]

- 아래 4 개의 클래스로 나누어서 구현합니다.
   - Todo 클래스: 이 클래스는 각 할 일의 고유 번호와 내용을 저장합니다.
   - TodoRepository 클래스: 이 클래스는 할 일 추가, 삭제, 조회 등의 기능을 관리합니다.
   - TodoView 클래스: 이 클래스는 사용자의 입력과 시스템의 출력을 담당합니다.
   - TodoController 클래스: 중앙에서 관리하는 역할이며, TodoRepository로부터 데이터를 요청하고, 처리된 결과를 TodoView를 통해 출력합니다.



## 3 단계
**추가 요구사항 구현**

[요구사항]

1. 할 일 완료 기능
   - 할 일이 추가될 때, 할 일 상태의 기본 값은 '[미완료]' 입니다.
   - 할 일 조회 시, 상태도 함께 표시됩니다.
   - 입력받은 ID의 할 일을 찾아 완료 상태로 변경합니다.
     - 완료 상태로 변경 시, 해당 할 일 옆에 '[완료]' 표시가 추가됩니다.
     - 해당 ID의 할 일이 없을 경우, "해당 ID의 할 일이 없습니다." 메시지를 출력합니다.
2. 전체 할 일 목록 출력
   - 오늘로부터 이후 7일 이내에 마감되는 할 일만 출력합니다. 
   - 마감일을 기준으로 오름차순 정렬합니다. 
3. 할 일 마감일 설정
   - 사용자가 할 일을 추가할 때, 마감일을 입력할 수 있습니다.
   - 할 일 조회 시, 마감일도 함께 표시됩니다.
4. 키워드 검색 기능
   - 사용자로부터 키워드를 입력 받습니다.
   - 해당 키워드를 포함하는 할 일을 검색합니다.
     - 마감일을 기준으로 오름차순 정렬합니다. 
     - 키워드가 포함된 할 일이 없을 경우, "검색 결과가 없습니다." 메시지를 출력합니다.
5. 향상된 출력 기능
   - 출력 시, 아래와 같은 포맷으로 출력합니다.
     ![image](https://github.com/lehdqlsl/java-todo-list/assets/7637916/29fbe7fd-09be-4996-beaa-cfffc4b92fc2)

- 힌트
  - 정렬 기능은 Collections.sort 메소드를 활용합니다.
  - 향상된 출력 기능은 String.format 메소드를 활용합니다.
  - 객체 출력 시, toString 메소드를 활용해보세요.




 ## 4 단계

### 1. TodoUI 클래스의 책임 분리

현재 TodoUI 클래스는 Todo 관련 메시지 출력 및 입력 관련 메시지 출력의 두 가지 주요 책임을 가지고 있습니다. 이를 Single Responsibility Principle(SRP)에 따라 분리하여 각 클래스의 책임을 명확하게 할 필요가 있습니다.

1. **TodoView 클래스 도입**
   - Todo와 관련된 출력을 담당합니다. 예를 들어, 할 일 목록, 완료된 할 일 등의 메시지 출력에 관한 로직을 포함합니다.
2. **InputView 클래스 도입**
   - 사용자로부터의 입력을 안내하고 받아오는 책임을 담당합니다. 예를 들어, 할 일 추가, 삭제, 수정 등의 액션을 선택받거나, 할 일의 내용을 입력받는 등의 기능을 제공합니다.


### 2. Repository 패턴 도입

Repository 패턴은 데이터 액세스 로직을 중심화하고 데이터 스토어에 대한 접근을 추상화하는 것 입니다. 이를 위해, Todo 데이터에 관련된 CRUD(Create, Read, Update, Delete) 연산들을 담당하는 Repository 인터페이스를 설계합니다.

1. **TodoRepository 인터페이스 및 구현체 작성**
   - `TodoRepository` 인터페이스를 정의하고, 이를 구현하는 클래스를 작성합니다.
     - 인터페이스 정의 시, 변경을 최소화 하기 위해 기존  정의된 메소드 이름을 그대로 적용합니다.
     - TodoRepository 클래스를 `MapTodoRepository`로 이름을 변경하고,  인터페이스 `TodoRepository`를 상속받습니다.

2. **데이터베이스 연결 및 데이터 처리**
   - MySQL에 연결하기 위한 설정을 합니다.
   - 데이터베이스에 연결하여 할 일 데이터를 저장하고 읽는 메소드를 Repository 인터페이스를 상속 받아 `MySQLTodoRepository` 를 구현합니다.
     - Jdbc 또는 MyBatis 사용

3. **저장소 전환의 유연성**
   - 애플리케이션 설정이나 실행 중에 `TodoRepository`의 구현체를 변경하면, 메모리 저장소와 데이터베이스 저장소 사이를 쉽게 전환할 수 있어야 합니다.
   - 예를 들어, 테스트 환경에서는 메모리 저장소를 사용하고, 실제 프로덕션 환경에서는 데이터베이스를 사용하는 등의 유연한 전환이 가능해야 합니다.
