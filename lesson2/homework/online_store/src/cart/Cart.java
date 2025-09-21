package cart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import product.Product;
import Exceptions.ProductNotFoundException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class Cart {
    private final List<Product> products;
    
    private final Multimap<String, Product> brandIndex;
    private final Multimap<String, Product> nameIndex;
    private final Multiset<String> brandCounts;
    private final Multiset<String> nameCounts;

    // constructors
    public Cart() { this(new ArrayList<>()); }

    public Cart(List<Product> products) {
        this.products = new ArrayList<>();
        this.brandIndex = ArrayListMultimap.create();
        this.nameIndex  = ArrayListMultimap.create();
        this.brandCounts = HashMultiset.create();
        this.nameCounts  = HashMultiset.create();

        if (products != null) {
            for (Product p : products) {
                if (p != null) {
                    this.products.add(p);
                    indexAdd(p);
                }
            }
        }
    }

    // helpers
    private void customPrint(String text) { System.out.print(text); }

    private String key(String s) {
        return (s == null) ? "" : s.trim().toLowerCase(Locale.ROOT);
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= products.size();
    }

    private static class Finder {
        Product byId(List<Product> list, int id) throws ProductNotFoundException {
            if (list == null || list.isEmpty())
                throw new ProductNotFoundException("cart is empty");
            for (Product p : list) {
                if (p != null && p.getId() == id) return p;
            }
            throw new ProductNotFoundException("product id=" + id + " not found");
        }
    }

    private void indexAdd(Product p) {
        String bk = key(p.getBrand());
        String nk = key(p.getName());
        brandIndex.put(bk, p);
        nameIndex.put(nk, p);
        brandCounts.add(bk);
        nameCounts.add(nk);
    }

    private void indexRemove(Product p) {
        if (p == null) return;
        String bk = key(p.getBrand());
        String nk = key(p.getName());
        brandIndex.remove(bk, p);
        nameIndex.remove(nk, p);
        brandCounts.remove(bk);
        nameCounts.remove(nk);
    }

    // methods
    public void addToCart(Product product) {
        if (product == null) return;
        products.add(product);
        indexAdd(product);
    }

    public void addToCart(Product[] products) {
        if (products == null) return;
        for (Product item : products) {
            if (item != null) {
                this.products.add(item);
                indexAdd(item);
            }
        }
    }

    public void removeFromCartByIndex(int index) {
        if (!isOutOfBounds(index)) {
            Product removed = products.remove(index);
            indexRemove(removed);
        }
    }

    public void removeFromCartByName(String name) {
        if (name == null || name.isBlank()) return;
        String target = key(name);
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product p = it.next();
            if (p != null && key(p.getName()).equals(target)) {
                it.remove();
                indexRemove(p);
            }
        }
    }

    public void printProductsWithDetails() {
        for (int i = 0; i < products.size(); i++) {
            customPrint("index: " + i + "\n");
            products.get(i).print();
            customPrint("\n");
        }
    }

    public void printAllProducts() {
        for (int i = 0; i < products.size(); i++) {
            products.get(i).print();
            customPrint("\n");
        }
    }

    public void printProductByIndex(int index) {
        if (isOutOfBounds(index)) return;
        products.get(index).print();
    }

    public Product getByIdOrThrow(int id) throws ProductNotFoundException {
        return new Finder().byId(this.products, id);
    }

    public Product findById(int id) {
        try {
            return getByIdOrThrow(id);
        } catch (ProductNotFoundException e) {
            customPrint("ProductNotFoundException: " + e.getMessage() + "\n");
            return null;
        }
    }

    public float getTotal() {
        float sum = 0;
        for (Product p : products) sum += p.getPrice();
        return sum;
    }

    @Override
    public String toString() {
        return "Cart{items=" + products.size() + ", total=" + getTotal() + "}";
    }
    
    public void printProductsByBrand(String brand) {
        String bk = key(brand);
        Collection<Product> list = brandIndex.get(bk);
        System.out.println("Products by brand='" + brand + "': " + list.size());
        for (Product p : list) {
            p.print();
            System.out.println();
        }
    }
    
    public void printBrandCounts() {
        System.out.println("Brand counts:");
        for (Multiset.Entry<String> e : brandCounts.entrySet()) {
            System.out.println("  " + e.getElement() + " × " + e.getCount());
        }
    }
    
    public void printNameCounts() {
        System.out.println("Name counts:");
        for (Multiset.Entry<String> e : nameCounts.entrySet()) {
            System.out.println("  " + e.getElement() + " × " + e.getCount());
        }
    }
    
    public int getCount() { return products.size(); }
}
