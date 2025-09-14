package practice;

import java.util.*;
 
class Cat {
	public String name;
	@Override
	public String toString() { return this.name; };
}

class ByNameLengthDesc implements Comparator<Cat> {
	@Override
	public int compare(Cat a, Cat b) {
		return Integer.compare(
			b.name.length(), 
			a.name.length()
		);
	}
}

public class Program {
	public static void main(String[] args) {
		PriorityQueue<Cat> q = new PriorityQueue<>(new ByNameLengthDesc());
		
		Cat a = new Cat();
		a.name = "Murchyk";
		
		Cat b = new Cat();
		b.name = "Vaska";
		
		Cat c = new Cat();
		c.name = "Barsik";
		
		q.add(a);
		q.add(b);
		q.add(c);
		
		System.out.println(q);
		q.remove();
		
		System.out.println(q);
		
	}
}
