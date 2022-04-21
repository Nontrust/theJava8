package optional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<OnlineClass>();
		springClasses.add(new OnlineClass(1,"spring boot",true));
		springClasses.add(new OnlineClass(2,"spring data jpa",true));
		springClasses.add(new OnlineClass(3,"spring mvc",false));
		springClasses.add(new OnlineClass(4,"spring core",false));
		springClasses.add(new OnlineClass(5,"rest api development",false));
		
		List<OnlineClass> javaClasses = new ArrayList<OnlineClass>();
		javaClasses.add(new OnlineClass(6, "The Java, Test", true));
		javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
 		javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));
	}

}
