package escapingreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This code demonstrates unsafe practice passing reference that can cause escaping-reference.
 * Escaping reference can cause security breach via object data modification.
 */
public class NotSafe {
    static class Order<T> {
        private LocalDate localDate;
        private User user;
        private List<T> products;
        
        public Order(LocalDate localDate, User user, List<T> products) {
            this.localDate = localDate;
            this.user = user;
            this.products = products;
        }
        
        public Order() {
        }
        
        public LocalDate getLocalDate() {
            return localDate;
        }
        
        public User getUser() {
            return user;
        }
        
        public List<T> getProducts() {
            return products;
        }
        
        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }
        
        public void setUser(User user) {
            this.user = user;
        }
        
        public void setProducts(List<T> products) {
            this.products = products;
        }
    }
    
}

class User {
    private String name;
    private Address address;
    private SensitiveObject sensitiveObject;
    
    public User(String name, Address address, SensitiveObject sensitiveObject) {
        this.name = name;
        this.address = address;
        this.sensitiveObject = sensitiveObject;
    }
    
    public User() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public SensitiveObject getSensitiveObject() {
        return sensitiveObject;
    }
    
    public void setSensitiveObject(SensitiveObject sensitiveObject) {
        this.sensitiveObject = sensitiveObject;
    }
}

class Address {

}

record SensitiveObject(int secretCode) {

}

class DemoEscapingProduct {
    
    public static void main(String[] args) {
        User user = new User("Maaike", new Address(),  new SensitiveObject(123));
        
        List<String> products = new ArrayList<>();
        products.add("drinking bottle");
        
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product());
        
        NotSafe.Order order = createOrder(user, products);
        NotSafe.Order order1 = createOrder(user, products1);
        
        System.out.println("===Original===");
        printProducts(order.getProducts());
        printProducts(products1);
        
        System.out.println("===Copy===");
        List<String> copy = order.getProducts();
        printProducts(copy);
        List<Product> copy1 = order1.getProducts();
        printProducts(copy1);
        
        System.out.println("===Modifying copy===");
        copy.add("cable mat");
        copy1.add(new Product());
        
        System.out.println("===Original===");
        printProducts(order.getProducts());
        printProducts(order1.getProducts());
        
        System.out.println("===Copy===");
        printProducts(copy);
        printProducts(copy1);
        
        System.out.println("===Comparring original and copy===");
        System.out.println("List reference are same: " + order.getProducts().equals(copy));
        System.out.println("1st item reference are same: " + order.getProducts().get(0) == copy.get(0));
        System.out.println("2nd item reference are same: " + order.getProducts().get(1) == copy.get(1));
        
        System.out.println("===Comparring original and copy===");
        System.out.println("List reference are same: " + order1.getProducts().equals(copy1));
        System.out.println("1st item reference are same: " + (order1.getProducts().get(0) == copy1.get(0)));
        System.out.println("2nd item reference are same: " + (order1.getProducts().get(1) == copy1.get(1)));
    }
    
    static <T> void printProducts(List<T> products) {
        for (T product : products) {
            System.out.println(product);
        }
    }
    
    static <T> NotSafe.Order createOrder(User user, List<T> products) {
        return new NotSafe.Order(LocalDate.now(), user, products);
    }
    
    
}

class Product {
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

