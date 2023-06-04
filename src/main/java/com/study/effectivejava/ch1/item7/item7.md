# Item 7

## 다 쓴 객체 참조를 해제하라

- 어떤 객체에 대한 레퍼런스가 남아있다면 해당 객체는 GC 대상이 되지 않음
- 자기 메모리를 직접 관리하는 클래스라면 메모리 누수에 주의
  - 스택, 배열, 리스트 등과 같은 `객체를 쌓아두는 공간`이 있는 경우, 캐시, 리스너, 콜백
- 참조 객체를 null 처리하는 일은 예외적인 경우며 가장 좋은 방법은 `유효범위 밖으로 밀어 내는 것`
  - 하지만 의외로 null 처리하는 건 흔한 경우임...
- WeakHashMap 과 같은 특정한 자료구조를 사용
- 백그라운드 쓰레드를 이용해서 주기적으로 Clean up 작업을 실행
  - ScheduledThreadPoolExecutor

## 완벽 공략

- NullPointerException
- WeakHashMap
  - weak reference
- Background Thread
  - ScheduledThreadPoolExecutor

### NullPointerException(NPE)

- `Optional`을 활용해서 NPE 를 최대한 피하자
  - 무조건 리턴타입으로만 사용하자
- NPE 를 만나는 이유
  - 메서드에서 null 을 리턴하기에
  - null 체크를 하지 않기 떄문에
- 메서드가 적절한 값을 리턴할 수 없는 경우
  - 예외를 던진다
  - null 을 리턴한다
  - Optional 을 리턴한다

### WeakHashMap

- 더이상 사용하지 않는 객체를 GC 할때 자동으로 삭제해주는 맵
- key 가 더이상 strong reference 되는 곳이 없다면 해당 엔트리를 제거
- 레퍼런스의 종류
  - strong
    - 우리가 흔히 사용하는 `=`를 이용하여 할당하는 경우  
  - soft
    - 더 이상 strong reference 가 없고, `soft reference만 남은 경우` gc 의 대상이 됨
    - 단, 메모리가 필요한 상황에만!
  - weak
    - soft 와 동일하게 strong 이 없으면 항상 gc 의 대상이 됨
  - phantom
    - `ReferenceQueue`를 같이 사용해야함
    - soft, weak 과 마찬가지로 gc 의 대상이되면 원래 오브젝트는 정리가 되지만, phantom object 를 ReferenceQueue 에 넣어줌
    - 용도
      - 자원 정리
      - 언제 객체가 메모리 해제되는지 알 수 있음
- 맵의 엔트리를 맵의 value 가 아니라 key 에 의존하는 경우에 사용가능
  - key 가 유효하지 않으면, value 도 무의미해지는 경우에만 사용 
- 캐시를 구현하는데 사용 가능하지만, 직접 구현은 권장하지 않음
- 추가적으로 WeakHashMap 을 사용할 떄는 커스텀한 reference type 을 key 로 가지게 해야함
  - 즉, Wrapper(Integer, Long ..) type 을 key 로 가지게 하면 안됨
  - Wrapper type 을 key 로 가지게되면 JVM 에서 캐싱을 하는 경우가 발생

### ScheduledThreadPoolExecutor

- Thread, Runnable, ExecutorService
- 쓰레드풀의 갯수를 정할 때 주의할 것
  - CPU, I/O
    - CPU intensive 한 작업일 땐 CPU 갯수 만큼만 쓰레드 풀을 만들자
    - I/O intensive 한 작업일 땐 I/O 딜레이 떄문에 작업이 지연될 수 있음
      - 기본적으로 갯수를 CPU 갯수보다 더 잡아야하지만, 지연시간에 따라 적절한 쓰레드풀의 갯수를 산정해야함
- 쓰레트풀의 종류
  - Single, Fixed, Cached, Scheduled
  - Fixed
    - BlockingQueue
      - Concurrent 하게 접근 가능
  - Cached
    - 놀고있는 쓰레드가 있으면 재사용, 없다면 새로 만들어서 할당
    - 일을 안하는 쓰레드가 있으면 60초 후 쓰레드 삭제
    - 자원 낭비가 있을 수 있으므로 조심히 써야함
  - Scheduled
    - 몇 초 뒤에 실행하거나 주기적으로 실행될 때 사용
- Runnable, Callable, Future
  - Runnable 은 return type 이 없음
  - Callable, Future
    - return 을 받고 싶을 때 callable 과 future 를 사용
- CompletableFuture, ForkJoinPool
  - 비동기 통신에서 사용