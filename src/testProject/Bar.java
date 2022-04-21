package testProject;

// 이 클래스는 Default 로 선언된 printNameUpperCase 를 사용하고 싶지 않음
public interface Bar{
	
	default void printNameUpperCase() {
		System.out.println("BAR");
	}

}
