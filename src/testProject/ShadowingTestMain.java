package testProject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ShadowingTestMain {
    public static void main(String ...args) {        
    	
    	
    	String[] names = {"Keesun","choongho","whiteship","toby"};
    	Arrays.sort(names, String::compareToIgnoreCase);
    	
    	System.out.println(Arrays.toString(names));
    	
    	
//    	Function<Integer, String> intTostring = (i) -> "Number";
//    	UnaryOperator<String> hi = (s) -> "hi" + s;
    	UnaryOperator<String> hi = Greeting::hi;
    	
    	Greeting greeting = new Greeting();
    	UnaryOperator<String> hello = greeting::hello;
    	
    	//��üȭ �� Instance ���� �� ����
    	Supplier<Greeting> newGreeting = Greeting::new;
    	//��üȭ ��
    	newGreeting.get();
    	
    	//function �� �������� ���� ��? 
    	Function<String, Greeting> choonghoGreeting = Greeting::new;
    	
    	Greeting chooongho= choonghoGreeting.apply("choongho");
    	System.out.println(chooongho.getName());
    }
    
}