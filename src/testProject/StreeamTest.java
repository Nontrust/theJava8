package testProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreeamTest {
	public static void main(String[] Args) {
		//��Ʈ���� ������(�÷���)�� �ƴ� �����͸� �ҽ��λ���ؼ� ó����
		//���� �����͸� �������� ����
		//��Ʈ������ ó���ϴ� �����ʹ� 1����, ���� ������ �� �� ���� �� Short Circuit�޼ҵ���
		
		List<String> names = new ArrayList<>();
		names.add("keesun");
		names.add("toby");
		names.add("whiteship");
		names.add("foo");
		names.add("choongho");
		
		//�߰� operation -> Stream Return, �͹̳� operation �ٸ� Ÿ�� Return
		//�߰����۷��̼��� �⺻������ Lazy��
		
		List<String> collect2 = names.parallelStream().map(String::toUpperCase)
				.collect(Collectors.toList());
		
		collect2.forEach(System.out::println);
		
		List<String> collect = names.stream().map(s->{
			System.out.println(s);
			return s.toUpperCase();
		}).collect(Collectors.toList());
		
	}

}
