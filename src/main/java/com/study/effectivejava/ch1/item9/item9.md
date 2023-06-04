# Item 9

## try-finally 보다 try-with-resources 를 사용하라

- `try-with-resources`를 사용하면 코드가 짧아지고 분명
  - 자원을 해제해야되는 변수들이 중첩되거나 늘어나면 더욱 유용
    - 중첩되는 경우 자원 해제의 순서도 중요하기 때문에
- 만들어지는 예외 정보도 보다 유용
  - try-catch 만 사용하면 가장 마지막에 발생한 예외만 나타남
  - `try-with-resources`는 발생하는 예외를 모두 순서대로 보여줌
    - 즉 가장 처음에 발생한 예외부터 볼 수 있기에 매우매우 유용

## 완벽 공략

- 자바 퍼즐러 예외 처리 코드의 실수
- try-with-resources 바이트 코드
  - intellij 의 build 폴더 내 classes 를 한번 살펴보자!
  - `addSuppressed`와 중첩된 try-catch block