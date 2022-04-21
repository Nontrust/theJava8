package testProject;

public class DefaultFoo implements Foo, Bar{
	
	String name;
	
	public DefaultFoo(String name) {
		this.name =name;
	}

	@Override
	public void printName() {
		System.out.print(this.name);
		
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void printNameUpperCase() {
		this.name.toUpperCase();
	}
}
