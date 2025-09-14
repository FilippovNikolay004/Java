package cart;

import java.util.ArrayList;
import java.util.List;

import product.Product;

public class Cart {
	private List<Product> products;
	
	// constructors
	public Cart() {
        this(new ArrayList<>());
    }
	public Cart(List<Product> products) {
		this.products = new ArrayList<>();
		
    	if (products != null) {
            for (Product p : products) {
                if (p != null) 
                	this.products.add(p);
            }
        }
    }
	
	// helpers
	private void customPrint(String text) {
		System.out.print(text);
	}
	private boolean equalsName(Product p, String name) {
        String n = p.getName();
        return n != null && 
        		n.equalsIgnoreCase(name);
    }
	private boolean isOutOfBounds(int index) {
		return index < 0 || 
				index >= products.size();
	}
	
	// methods
	public void addToCart(Product product) {
		if (product == null) return;
		
		products.add(product);
	}
	public void addToCart(Product[] products) {
		if (products == null) return;
		
		for (Product item : products) {
			if (item != null) 
				this.products.add(item);
		}
	}
	public void removeFromCartByIndex(int index) {
		if (!isOutOfBounds(index)) 
			products.remove(index);
	}
	public void removeFromCartByName(String name) {		
		if (name == null || name.isBlank()) return;
		
		products.removeIf(p -> p != null && 
			equalsName(p, name));
	}
	public void printProductsWithDetails() {
		for(int i = 0; i < products.size(); i++) {
			customPrint("index: " + i + "\n");
			products.get(i).print();
			customPrint("\n");
		}
	}
	public void printAllProducts() {
		for(int i = 0; i < products.size(); i++) {
			products.get(i).print();
			customPrint("\n");
		}
	}
	public void printProductByIndex(int index) {
		if ((isOutOfBounds(index))) {
			return;
		}
		products.get(index).print();
	}
	public float getTotal() {
        float sum = 0;
        for (Product p : products) 
        	sum += p.getPrice();
        
        return sum;
    }
	
	@Override
    public String toString() {
        return "Cart{items=" + products.size() + ", total=" + getTotal() + "}";
    }
	
	// setters
	
	
	// getters
	public int getCount() { return products.size(); }
}