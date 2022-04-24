 package optional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	
	/*
	 * Optional은 return type으로만 사용하길 권장함
	 * Map에서 사용하면 안됨
	 * OptionalInt등의 프리미티브 타입 사용을 권장함  
	 * Optional에서는 null말고 empty();를 Return
	 * Optional을 Container type(Collection, Map, Stream Array, Optionl)으로 리턴 ㄴㄴ  
	 */
	public static void main(String[] args) {
		
		
		List<OnlineClass> springClasses = new ArrayList<OnlineClass>();
		springClasses.add(new OnlineClass(1,"spring boot",true));
		springClasses.add(new OnlineClass(5,"rest api development",false));
		
//		Optional<OnlineClass> spring = springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring")).findFirst();
		Optional<OnlineClass> spring = springClasses.stream().filter(oc -> oc.getTitle().startsWith("jpa")).findFirst();
		spring.isEmpty();
		
		spring.ifPresent(oc->System.out.print(oc.getTitle()));
		
		//orElse에 해당하는 객체가 있어도 내부 method실행
		OnlineClass onclineClass = spring.orElse(createNewJpaClasses());
		System.out.println(onclineClass.getTitle());

		//orElse에 해당하는 객체가 있어도 내부 method실행
		OnlineClass onclineClass2 = spring.orElseGet(()->createNewJpaClasses());
		OnlineClass onclineClass3 = spring.orElseThrow(IllegalStateException::new);
		Optional<OnlineClass> onclineClass4 = spring.filter(oc->!oc.isClosed());
		
		Optional<Integer> infeger = spring.map(OnlineClass::getId);
		Optional<Progress> progress = spring.flatMap(OnlineClass::getProgress);
		
		
		
 		
	}

	private static OnlineClass createNewJpaClasses() {
		System.out.println("craete new onwline classes");
		return new OnlineClass(10,"New Class",false);
	}

}
