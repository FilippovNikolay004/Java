package practice;

public class Program {
	public static void main(String[] args) {
		Double a = 10.5;                 
        Double b = Double.valueOf("20.7"); 
        Double c = Double.valueOf(15);     
        Double d = c;
        
        c += 5;

        System.out.println("Value: " + d); 
        System.out.println("Value: " + a);
        System.out.println("Value from string: " + b);
        System.out.println("Value from int: " + c);
        System.out.println("Is it finite? " + Double.isFinite(a));
        System.out.println("result: " + (a == b));
	}
}
