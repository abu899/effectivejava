# Item 25

## 톱 레벨 클래스는 한 파일에 하나만 담아라

- 한 소스 파일에 톱 레벨 클래스를 여러개 선언하면 컴파일 순서에 따라 결과가 달라질 수 있음
- 다른 클래스에 딸린 부차적인 클래스는 정적멤버 클래스로 만드는 것이 좋음
  - 가독성을 올리고, private 로 선언해서 접근 번위 또한 관리 가능