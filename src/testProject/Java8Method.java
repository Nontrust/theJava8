package testProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8Method {

	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		
		name.add("keesun");
		name.add("toby");
		name.add("whiteship");
		name.add("foo");
		name.add("choongho");
		
		Comparator<String> comToIgnoreCase = String::compareToIgnoreCase;
		name.sort(comToIgnoreCase.reversed());
		
		
		// collection ������ �ִ� ��ü���� stream ��� ����
		// ����ü�� spliter����Ͽ� �������
		Set<String> set = name.stream().map(String::toUpperCase).filter(s->s.startsWith("C")).collect(Collectors.toSet());
		set.forEach(System.out::println);
		
		name.removeIf(s->s.startsWith("f"));
		name.forEach(System.out::println);
		//name.forEach(System.out::print);
		
		/*Iterator<String> iter = name.iterator();
		Spliterator<String> spliter = name.spliterator();
		Spliterator<String> harfSpliter = spliter.trySplit();
		
		//function(consumer) �� ����
		while(spliter.tryAdvance(System.out::println));
		System.out.println("==================");
		while(harfSpliter.tryAdvance(System.out::println));*/
		
		
		

	}

}
