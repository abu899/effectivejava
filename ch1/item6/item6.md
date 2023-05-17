# Item 6

## 불필요한 객체 생성을 피하라

- 문자열
  - 사실상 동일한 객체라서 매번 새로 만들 필요 없음
  - new String 대신 `String Literal`을 사용해 동일한 문자열을 재사용하는 것이 좋음
- 정규식
  - 생성비용이 비싸기 떄문에 반복 생성 대신, 캐싱하여 재사용
- 오토 박싱
  - 기본 타입을 상응하는 박싱된 기본타입으로 상호 변환해주는 기술
  - 기본 타입과 박싱된 타입을 섞어 사용하면 변환 과정에서 불필요한 객체가 생성됨

## 완벽 공략

- 사용 자제 API(Deprecated)
- 정규 표현식
- 한번 쓰고 버려져서 가비지 컬렉션 대상이 된다
- 초기화 지연 기법(Item 83)
- 방어적 복사(Item 50)
  - 새로운 객체를 만들 때, 기존 객체를 카피하지마라

### Deprecation

- 클라이언트가 사용하지 않길 바라는 코드가 있다면 `Deprecation`을 사용하자
- @Deprecated
  - 컴파일시 경고 메시지를 통해 사용자제를 권장하는 API 라고 알려줌
- @deprecated
  - 문서화에 사용해 해당 API 사용을 지양하며 권장하는 API 가 어떤 것인지 표시 가능

### 정규표현식

- 내부적으로 Pattern 이 쓰이는 곳
- String.matches
- String.split
  - 한글자로 문자를 쪼개는건 속도가 빠름.. 한글자 이상인 경우에만 대안을 사용 
  - 대안: Pattern.compile(regex).split(str)
- String.replace(String regex, String replacement)
  - 대안: Pattern.compile(regex).matcher(str).replaceAll(repl)

### 가비지 컬렉션

- 스터디 가이드
  1. 가비지 컬렉션 개념
  2. 자바에 줄 수 있는 옵션
     - GC 로깅이나 시간을 출력하거나 등
     - GC 를 선택하는 옵션 및 각 알고리즘마다의 특징
  3. 가비지 컬렉션 툴
     - JStat, JConsole
- Mark, Sweep, Compact
  - Mark
    - 오브젝트가 참조를 가지고 있는지 체크해두는 것
    - 가비지 컬렉션의 대상이 되는가
  - Sweep
    - 필요없는 오브젝트를 힙에서 지우는 것
  - Compact
    - 파편화되어있는 공간을 모으는 과정
- Young Generation(eden, s0, s1), Old Generation
- Minor GC, Full GC
  - Full GC 가 중요
- Throughput, `Latency(Stop-The-World)`, Footprint
  - Throughput
    - 어플리케이션의 처리량
    - GC 가 Throughput 을 얼마나 영향을 주느냐를 봐야함
  - Latency(Stop-The-World)
    - 어플리케이션이 멈추는 시간
  - Footprint
    - GC 수행함에 있어 얼마만의 메모리를 사용하나
- Serial, Parallel, CMS, G1, `ZGC`, Shenandoah
  - Java 8의 기본은 Parallel GC, Serial 과 같은 방법이지만 쓰레드를 더 많이 씀
  - Java 11은 G1 GC
  - Serial 과 Parallel 은 Latency 관점에서 좋은 GC 는 아님
  - CMS 부터는 Latency 에 신경쓰는 GC
    - 물론 trade-off 가 존재