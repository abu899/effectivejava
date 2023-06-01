# Item 13

## clone 재정의는 주의해서 진행하라

- clone 규약
  - `x.clone() != x` 
    - true
    - reference 자체가 다른 인스턴스여야 함
  - `x.clone().getClass() == x.getClass()` 
    - true
    - 원본 클래스는 같아야함
  - `x.clone.equals(x)` 
    - true 가 아닐 수도 있음
    - 복사를 했어도 id는 달라져야 하는 경우

### 불변 객체를 clone 하는 방법

- Cloneable 인터페이스를 구현
- clone 메서드를 재정의하고, 이때 `super.clone()` 사용
  - 생성자를 통해 clone 을 구현하게 되면 하위 클래스에서 clone 을 재정의 하는 순간 문제가 발생
  - 하위클래스에서 재정의 하지 않더라도 하위클래스에서 clone 을 사용할 때 형변환을 하게되면 문제가 발생
- super.clone() 은 호출하는 위치에 따라 실제 나오는 인스턴스 타입이 달라짐 

### 가변객체를 clone 하는 방법

- 접근 제한자는 public, 반환 타입은 자신의 클래스로 변경
- super.clone 을 호출한 뒤 필요한 필드를 수정
- 여기까지는 불변 객체와 같음
  - 배열을 복제할 때는 배열의 clone 메서드 사용
  - 경우에 따라 final 을 사용할 수 없을 수 있음
    - 기존에 있던 설정값을 다시 설정해줘야하는 상황이 있기에 final 을 못 붙일 수 있음
  - 경우에 따라 deep copy
- 대안
  - super.clone 으로 객체를 만든 뒤, 고수준 메서드를 호출하는 방법도 존재
  - 복사 생성자 또는 복사 팩터리
- 주의사항
  - 오버라이딩 할 수 있는 메서드는 참조하지 않도록 조심
    - 하위 클래스에서 동작이 변경될 가능성이 존재
  - 상속용 클래스는 Cloneable 을 구현하지 않는 것이 좋음
  - Cloneable 을 구현한 스레드 안전 클래스를 작성할 때는 동기화를 해야함

## 완벽 공략

- Unchecked Exception
- HashTable 과 LinkedList
- Deep copy
- 리스트가 길면 Stack overflow 를 일으킬 위험이 있음
- clone 메서드 역시 적절히 동기화
- TreeSet

### Unchecked Exception

- RuntimeException, Error = Unchecked exception
- 컴파일 에러를 신경쓰지 않아도 됨
- try-catch 로 감싸거나 밖으로 던질 수 있음
- 메서드 선언부에 선언하지 않아도 됨
  - 메서드에 선언한 예외는 프로그래밍 인터페이스의 일부(API)
  - 즉, 메서드를 사용하는 코드가 반드시 알아야 하는 정보
- 그럼 언제 Checked Exception 을 사용해야할까?
  - 반드시 어떤 예외가 발생할 수 있음을 알릴 때
  - 사용자가 예외를 처리할 수 있을 때, 즉, 대응 및 복구 시도가 가능할 때
- Unchecked Exception 은 어떤식으로든 처리하거나 복구하기 어려운 경우
  - 하지만 이러한 예외는 프로그램 어디서나 발생할 수 있기에 항상 메서드에 예외를 선언하면 프로그램의 명확도가 떨어짐
- 사용하기 편하다고 RuntimeException 을 선택하지 말자
  - 복구가 가능하면 CheckedException, 불가능하다면 RuntimeException

### TreeSet

- `AbstractSet`을 확장한 `정렬된 컬렉션`
  - 넣을 때 부터 정렬되어 있음
- 엘리먼트를 추가한 순서는 중요하지 않고 엘리먼트가 지닌 자연적인 순서(natural order)에 따라 정렬
  - Comparable
- 오름 차순으로 정렬
- 스레드에 안전하지 않음