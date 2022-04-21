package testProject;

public interface Foo {
	void printName();
	
	/**
	 * @impleSpec 
	 * 이 구현체는 어떤일을 하는지 스펙을 알려준다
	 * 또한 default 는 Object class 안에 있는 메서드를 재 정의 할 수 없음 
	 */
	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}
	
	static void printAnything() {
		System.out.println("Foo");
	}
	
	String getName();
}
