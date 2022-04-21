package testProject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class testMain {

	public static void main(String[] args) {
		String[] arr = new String[] {"a","b","c"};
		Stream<String> stream = Arrays.stream(arr);
		Stream<String> stremOfArrayPart = Arrays.stream(arr,1,3);;
		
		List<String> list = Arrays.asList("a","b","c");
		Stream<String> stream2 = list.stream();
		Stream<String> parallelStream1 = list.parallelStream();
		Stream<String> builderStream = Stream.<String>builder().add("1").add("2").add("3").build();

		Stream<String> generatedSteam =Stream.generate(()->"gen").limit(5);
		Stream<Integer> iteratedStream = Stream.iterate(30, n -> n+2).limit(5);
		
		IntStream intStream = IntStream.range(1, 5);
		LongStream longStream = LongStream.rangeClosed(1, 5);
		
		Stream<Integer> boxedIntStream = IntStream.range(1,5).boxed();
		
		DoubleStream doubles = new Random().doubles(3);
		
		IntStream charsStream = "StringToCharArray".chars();
		
		Stream<String> stringStream = Pattern.compile(", ").splitAsStream("1, 2, 3, 4");
		
		try {
			Stream<String> lineStream = Files.lines(Paths.get("C:/Users/deed1/OneDrive/πŸ≈¡ »≠∏È"),Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		ArrayList<Product> productList = new ArrayList<>();
		productList.add(new Product());
		productList.add(new Product());
		productList.add(new Product());
		productList.add(new Product());
		Stream<Product> parallelStream = productList.parallelStream();
		
		boolean isParallel = parallelStream.isParallel();

		
		boolean isMany = parallelStream.map(product -> product.getAmount()*10).anyMatch(amount->amount>200);
		
		Arrays.stream(arr).parallel();
		
		IntStream intStream2 = IntStream.range(1, 150).parallel();
		boolean isParallel2 = intStream2.isParallel();
		
		IntStream intStream3 = intStream.sequential(); 
		
		Stream<String> stream4 = Stream.of("1","2","3");
		Stream<String> stream5 = Stream.of("4","5","6");
		Stream<String> concatStream = Stream.concat(stream4, stream5);
		
		List<String> names = Arrays.asList("Eric", "Elena", "Java");
		List<List<String>> nonFlatList = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
		
		Stream<String> includeAInNameUseFilter = names.stream().filter(name -> name.toUpperCase().contains("A"));
		Stream<String> toUpperCaseUseMap = names.stream().map(String::toUpperCase);
		Stream<Integer> getAmountListStreamUseMap = productList.stream().map(Product::getAmount);
		
		List<String> flattenStreamList = nonFlatList.stream().flatMap(Collection::stream).collect(Collectors.toList());
		
		IntStream.of(14,11,20,39,23).sorted().boxed().collect(Collectors.toList());
		
		List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
			
		lang.stream().sorted().collect(Collectors.toList());
		lang.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		lang.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		lang.stream().sorted((s1,s2)->s2.length()-s1.length()).collect(Collectors.toList());
		
		int sum = IntStream.of(1,3,5,7,9).peek(System.out::println).sum();
		long count = IntStream.of(1,3,5,7,9).count();
		long sumStream = IntStream.of(1,3,5,7,9).sum();
		
		OptionalInt min = IntStream.of(1,3,5,7,9).min();
		OptionalInt max = IntStream.of(1,3,5,7,9).max();
		
		OptionalInt reduced = IntStream.range(1, 4).reduce((a,b)->{return Integer.sum(a, b);});
		int reducedTwoParam = IntStream.range(1, 4).reduce(10, Integer::sum);
		
		Integer reducedParams = Stream.of(1,2,3).reduce(10, Integer::sum, (a,b) -> {
			System.out.println("combiner was not called");
			return a+b;
		});
		
		Integer reducedParallel = Arrays.asList(1,2,3).parallelStream().reduce(10, (a,b)->{
			System.out.println("combiner is called");
			return a+b;
		});
		
		List<Product> productLists = 
		  Arrays.asList(new Product(23, "potatoes"),
				  		new Product(14, "orange"),
				  		new Product(13, "lemon"),
				  		new Product(23, "bread"),
				  		new Product(13, "sugar"));
		
		List<String> collectorCollection = productLists.stream().map(Product::getName).collect(Collectors.toList());
		String listToString = productLists.stream().map(Product::getName).collect(Collectors.joining(",","<",">"));
		Double averageAmount = productLists.stream().collect(Collectors.averagingInt(Product::getAmount));
		int summingAmount2 = productLists.stream().collect(Collectors.summingInt(Product::getAmount));
		Integer summingAmount = productLists.stream().mapToInt(Product::getAmount).sum();
		IntSummaryStatistics statistics = productLists.stream().collect(Collectors.summarizingInt(Product::getAmount));
		
		Map<Integer, List<Product>> collectorMapOfLists = productLists.stream().collect(Collectors.groupingBy(Product::getAmount));
		
		
		
		
	}
	
	public interface Collection<E> extends Iterable<E> {
		default Stream<E> stream(){
			return StreamSupport.stream(spliterator(), false);
		}
	}
	
	public Stream<String> streamOf(List<String> list){
		return list==null || list.isEmpty() ?
				Stream.empty() : list.stream();
	}
	
	public static<T> Stream<T> generate(Supplier<T> s){
		Stream<T> result = null;
		return result;
	}
	
	static class Product{
		String name;
		int amount=20;
		
		public Product(int amount, String name) {
			this.amount=amount;
			this.name=name;
		}
		
		public int getAmount() {
			return this.amount;
		}
		public String getName() {
			return this.name;
		}
	}

}
 