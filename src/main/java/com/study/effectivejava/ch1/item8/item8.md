# Item 8

## finalizer 와 cleaner 사용을 피하라

- finalizer 와 cleaner 는 즉시 수행된다는 보장이 없으며, 실행되지 않을 수도 있음
- finalizer 동작 중 예외가 발생하면 자원반납이 처리되지 않을 수도 있음
  - 심각한 성능 문제가 존재
- finalizer 는 보안적인 문제도 존재
- 반납할 자원이 있는 클래스는 `AutoCloseable`을 구현하고 클라이언트에서 close() 를 호출하거나 `try-with-resource`를 사용
- cleaner 는 언제 사용할까?
  - AutoCloseable 로 만들어 뒀지만, try-with-resource 로 사용하지 않은 경우에도 자원을 반납할 기회를 가질 수 있도록
  - cleaner safety net

## 완벽 공략

- Finalizer Attack
- AutoCloseable
- 정적이 아닌 중첩 클래스는 자동으로 바깥 객체의 참조를 갖는다
  - 즉 static 이 아닌 경우, 바깥 클래스에 대한 참조가 생겨 순환 참조가 생길 수 있음
  - 따라서 자원반납이 이루어 지지 않음
- 람다 역시 바깥 객체의 참조를 갖기 쉽다
  - 람다의 경우 바깥 객체의 필드나 메서드를 capture 하냐 안하냐에 따라 참조를 가질 수도 아닐 수도 있음
  - capture 하지 않으면 참조가 생기진 않음

### Finalizer Attack

- 만들다 만 객체를 finalize 메소드에서 사용하는 방법
- 방어하는 방법
  - final class 로 만들거나
  - finalizer() 메서드를 오버라이딩 한 다음 final 을 붙여서 하위클래스에서 오버라이딩 할 수 없도록 막음

### AutoCloseable

- `try-with-resource`를 지원하는 인터페이스
- void close() throws Exception
  - 인터페이스에 정의된 메서드에서 Exception 타입으로 예외를 던지지만 실제 구현체에서 `구체적인 예외를 던지는 것을 추천`
  - 가능하다면 `예외를 던지지 않는 것도 권장`
  - 가급적이면 idempotent(멱등성) 해야함
    - 몇 번을 실행해도 같은 결과가 나와야함
- Closeable 클래스와의 차이점
  - IOException 을 던지며, 반드시 idempotent 해야함
  - 리소스를 반환해야하는 클래스가 IO 와 관련이 있다면 Closeable 도 좋은 선택이 될 수 있음
    - DB 에 접근하거나 socket 을 열고 닫거나 등등