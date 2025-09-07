package second_project;

import modules.Cat;

public class Program {
	public static <T> void print(T text) {
		System.out.print(text);
	}
	public static <T> void print(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(arr.length - 1 != i ? ", " : "");
		}
	}
	public static <T> void print(String text, T arg) {
		System.out.print(text + arg);
	}
	public static <T> void print(String text, T[] arr) {
		System.out.print(text);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(arr.length - 1 != i ? ", " : "");
		}
	}
	
	// Practice 1
	public static void practice1() {
		var c = new Cat("Мурчик", 100, 100);
		c.eat("milk");
		c.print();
		print(c);
		
		int days = 365;
		for (int i = 0; i < days; i++) {
			print("=== ");
			print(i + 1);
			print(" ===");
			
			String[] favoriteMeals = c.getFavouriteMeal();
			int randomIndex = Cat.getRandomValue(0, favoriteMeals.length - 1);
			String randomMeal = favoriteMeals[randomIndex];
			
			print(c.getNick());
			System.out.println("eats " + randomMeal + "!");
			
			c.eat(randomMeal); 
            
            c.play();
            
            c.sleep();
            c.print();
            
            if (!c.isIsAlive()) {
            	print(c.getNick());
                System.out.println("didn't make it to day " + (i + 2) + ". 😿");
                break;
            }
		}
		if (c.isIsAlive()) {
			print(c.getNick());
            System.out.println("survived all 365 days! 🎉");
            c.print();
        }
	}
	
	// main
	public static void main(String[] args) {
		
	}
}
