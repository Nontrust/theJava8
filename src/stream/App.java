package stream;

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
		
		List<List<OnlineClass>> keesunEvent = new ArrayList<>();
		
		keesunEvent.add(springClasses);
		keesunEvent.add(javaClasses);
		/* --- */
		
		System.out.println("spring으로 시작하는 수업");
		//문제 1. 
		springClasses.stream().filter(c->c.getTitle().startsWith("spring")).forEach(oc->System.out.println("문제 1 : " + oc.getTitle()));
		
		System.out.println("close 되지 않은 수업");
		//문제 2. 
//		springClasses.stream().filter(c->!c.isClosed()).forEach(sc->System.out.println("문제 2 : " + sc.getId()));;
		springClasses.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(sc->System.out.println("문제 2 : " + sc.getId()));;

		System.out.println("수업 이름만 모아서 스트림 만들기");
		//문제 3.
		springClasses.stream().map(sc -> {return sc.getTitle();}).forEach(System.out::println);
		
		/* --- */
		
		System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
		//문제 4.
		keesunEvent.stream().flatMap(Collection::stream).map(oc->oc.getTitle()).forEach(System.out::println);;
		
		System.out.println("10부터 1씩 증가한하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
		//문제 5.
		Stream.iterate(10,i->i+1).skip(10).limit(10).forEach(System.out::println);
		
		System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 없는지 확인");
		//문제 6.
		boolean hi = javaClasses.stream().anyMatch(oc->oc.getTitle().contains("Test"));
		System.out.println(hi);
		
		
		System.out.println("스프링 수업중에 제목이 spring이 들어간 제목만 모아  List로 만들기");
		//문제 7.
		List<String> answer = springClasses.stream().filter(oc->oc.getTitle().contains("spring")).map(OnlineClass::getTitle).collect(Collectors.toList());
		answer.forEach(System.out::println);
	}

}
