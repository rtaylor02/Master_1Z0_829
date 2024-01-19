package escapingreference;

import classdefandreachability.accesscontrolmodifiers.a.P;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static escapingreference.AlmostSafe.createOrder;
import static escapingreference.DemoEscapingProduct.printProducts;

/**
 * This code demonstrates the safe way to accept reference and pass reference of a collection.
 * To completely detach the original collection (and its contents) from the copy, we need to do
 * deep copy as the process of cloning the original.
 * Steps:
 * 1) Collection items should override java.lang.Object clone() + implements Cloneable
 * 2) Collection should reference new object
 */
public class Safe {
    static class Order {
        private LocalDate localDate;
        private User user;
        private List<Product> products;
        
        public Order(LocalDate localDate, User user, List<Product> products) {
            this.localDate = localDate;
            this.user = user;
            this.products = new ArrayList<>(products);
        }
        
        public Order() {
        }
        
        public LocalDate getLocalDate() {
            return localDate;
        }
        
        public User getUser() {
            return user;
        }
        
        public List<Product> getProducts() throws CloneNotSupportedException {
            List<Product> copy = new ArrayList<>();
            for (Product product : products) {
                Product copyProduct = product.clone();
                copy.add(copyProduct);
            }
            return copy;
        }
        
        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }
        
        public void setUser(User user) {
            this.user = user;
        }
        
        public void setProducts(List<Product> products) {
            this.products = products;
        }
    }
    
    static class Product implements Cloneable {
        private String name;
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        @Override
        protected Product clone() throws CloneNotSupportedException {
            return (Product)super.clone();
        }
    }
    
    static Safe.Order createOrder(User user, List<Product> products) {
        return new Safe.Order(LocalDate.now(), user, products);
    }
    
    static void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
    
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("Maaike", new Address(),  new SensitiveObject(123));
        
        Product product = new Product();
        product.setName("shampoo");
        List<Product> products = new ArrayList<>();
        products.add(product);
        
        Safe.Order order = createOrder(user, products);
        
        System.out.println("===Original===");
        printProducts(order.getProducts()); // getProducts return a new list object containing new Product objects
        
        System.out.println("===Copy===");
        List<Product> copy = order.getProducts();
        printProducts(copy);
        
        System.out.println("===Modifying original===");
        products.get(0).setName("soap"); // Modifying the original will not alter copy as they are different objects
        
        System.out.println("===Original===");
        printProducts(order.getProducts());
        
        System.out.println("===Copy===");
        printProducts(copy);
    }
}
