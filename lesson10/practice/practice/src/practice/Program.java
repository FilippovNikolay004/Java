package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
    private final String name;
    private final int age;
    
    public Person(String name, int age) { 
    	this.name = name; 
    	this.age = age; 
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    
    @Override public String toString() { 
    	return name + " - " + age; 
	}
}

public class Program {
    public static void practice_1() {
        List<Person> people = new ArrayList<>(List.of(
            new Person("Sam Winchester", 21),
            new Person("Dean Winchester", 30),
            new Person("Castiel", 25),
            new Person("Crowley", 25),
            new Person("Bobby Singer", 19)
        ));

        System.out.println("By age, then by name:");
        people.stream()
              .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
              .forEach(System.out::println);

        System.out.println("\nBy age:");
        people.stream()
              .sorted(Comparator.comparing(Person::getAge).reversed())
              .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
    public static void practice_2() throws Exception {
    	URI uri = new URI("https://github.com/sunmeat/storage/raw/refs/heads/main/text/kobzar.txt");
    	
    	try (var reader = new BufferedReader(
                new InputStreamReader(uri.toURL().openStream(), Charset.forName("Windows-1251")))) {

            reader.lines()
                  .map(String::stripLeading)
                  .filter(s -> !s.isEmpty())
                  .filter(s -> Character.toUpperCase(s.charAt(0)) == 'А')
                  .forEach(System.out::println);
        }
    }

    public static void main(String[] args) throws Exception {
    	
    }
}
