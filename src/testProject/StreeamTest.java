package testProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreeamTest {
	public static void main(String[] Args) {
		//스트림은 데이터(컬렉션)가 아닌 데이터를 소스로사용해서 처리함
		//원본 데이터를 변경하지 않음
		//스트림으로 처리하는 데이터는 1번만, 만약 무제한 일 수 있을 시 Short Circuit메소드사용
		
		List<String> names = new ArrayList<>();
		names.add("keesun");
		names.add("toby");
		names.add("whiteship");
		names.add("foo");
		names.add("choongho");
		
		//중개 operation -> Stream Return, 터미널 operation 다른 타입 Return
		//중개오퍼레이션은 기본적으로 Lazy함
		
		List<String> collect2 = names.parallelStream().map(String::toUpperCase)
				.collect(Collectors.toList());
		
		collect2.forEach(System.out::println);
		
		List<String> collect = names.stream().map(s->{
			System.out.println(s);
			return s.toUpperCase();
		}).collect(Collectors.toList());
		
	}

}
