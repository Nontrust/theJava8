package testProject;

public class DefaultInterface {

	public static void main(String[] args) {
		
		Foo foo = new DefaultFoo("ChoongHo");
		foo.printName();
		foo.printNameUpperCase();
		
		Foo.printAnything();

	}

}
