package testProject;

public interface Foo {
	void printName();
	
	/**
	 * @impleSpec 
	 * �� ����ü�� ����� �ϴ��� ������ �˷��ش�
	 * ���� default �� Object class �ȿ� �ִ� �޼��带 �� ���� �� �� ���� 
	 */
	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}
	
	static void printAnything() {
		System.out.println("Foo");
	}
	
	String getName();
}
