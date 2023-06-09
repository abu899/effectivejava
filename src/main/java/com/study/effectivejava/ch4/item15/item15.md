# Item 15

## 클래스와 멤버의 접근 권한을 최소화 하라

### 구현과 API 를 분리하는 `정보 은닉`의 장점

- 시스템 개발 속도를 높임
  - 여러 컴포넌트를 병렬로 개발할 수 있기에
  - 인터페이스를 사용하는 쪽과 인터페이스를 지원하는 쪽이 동시에 개발이 가능
- 시스템 관리 비용을 낮춤
  - 컴포넌트를 더 빨리 파악 가능
  - 인터페이스를 기준으로 코드를 파악 가능
- 성능 최적화에 도움을 줌
  - 프로파일링을 통해 최적화할 컴포넌트를 찾고 다른 컴포넌트엔 영향을 주지 않고 해당 컴포넌트만 개선 가능
  - 성능에 영향을 많이 끼치는 모듈에 대해서만 교체 가능
- 소프트웨어 재사용성을 높임
  - 독자적인 컴포넌트일 시
- 시스템 개발 난이도를 낮춤
  - 전체를 만들기 전에 개별 컴포넌트를 검증 가능

### 클래스와 인터페이스의 접근 제한자 사용 원칙

- 모든 클래스와 멤버의 접근성을 가능한 좁혀야 함
- Top 레벨 클래스와 인터페이스에 `package-private` 또는 `public` 을 쓸 수 있음
  - public 으로 선언 하면 API 가 되므로 하위 호환성을 유지하려면 영원히 관리해야 함
    - 쉽게 바꾸기 어려움, public 으로 선언된 API 를 어디선가 사용 중에 있으면 변경으로 인해 영향을 끼치기에 영원히 관리해야함
  - 패키지 외부에서 쓰지 않을 클래스나 인터페이스라면 package-private
    - 내부에서만 쓰는 경우
- 한 클래스에서만 사용하는 package-private 클래스나 인터페이스는 해당 클래스에 private static 으로 중첩 시키자

### 멤버(필드, 메서드, 중첩 클래스, 인터페이스)의 접근 제한자 원칙

- `private과 package-private`는 내부 구현
- public 클래스 내 `protected와 public`은 공개 API
- 코드를 테스트하는 목적으로 private 를 package-private 으로 풀어주는 것은 허용 가능
  - 하지만 테스트만을 위해 멤버를 공개 API 로 만들어서는 안됨
  - 테스트를 같은 패키지에 만들면 됨
- public 클래스의 인스턴스 필드는 되도록 public 이 아니여야 함
- 클래스에서 public static final 배열 필드를 두거나 이 필드를 반화하는 접근자 메서드를 제공하면 안됨

## 완벽 공략

- Serializable
  - private, package-private 로 선언한 대상들도 의도치않게 공개 api 가 될 수 있음
- 하위 클래스는 상위 클래스로부터 override 받은 대상에 대해 접근지시자를 더 좁게 설정할 수 없음 
  - 리스코프 치환 원칙
- Thread Safe
- 상수로 공개할 필드(public static)는 기본타입이거나 불변 객체여야 함
- Java 9 모듈 시스템
  - 두 가지 암묵적 접근 수준

## 자바 플랫폼 모듈 시스템(Java Platform Module System, JPMS)

- JSR-376 스펙으로 정의한 자바의 모듈 시스템
- 안정성
  - 단순한 class path 가 아닌 관계를 표현이 가능
  - 순환 참조 허용하지 않음
  - 실행시 필요한 모듈 확인
  - 한 패키지는 한 모듈에서만 공개할 수 있음
- 캡슐화
  - public 인터페이스나 클래스라 하더라도 공개된 패키지만 사용할 수 있음
  - 내부 구현을 보호하는 수단으로 사용
- 확장성
  - 필요한 자바 플랫폼 모듈만 모아서 최적의 JRE 를 구성 가능
  - 작은 기기에서 구동할 어플리케이션 개발에 유용

