package escapingreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static escapingreference.DemoEscapingProduct.printProducts;

/**
 * This code demonstrates the (almost) safe way of accessing and receiving reference from method parameter.
 * In a nutshell, create a new object of the collection in the code to prevent using the original reference.
 * Why almost safe? Because the list is a new object with the same contents os the original. However, the
 * content of the original can still be referenced from the new copy. Hence, the contents can still be corrupted.
 * Solution to this is using deep copy, i.e. the collection and the contents are referencing new objects.
 */
public class AlmostSafe {
     static class Order<T> {
        private LocalDate localDate;
        private User user;
        private List<T> products;
        
        public Order(LocalDate localDate, User user, List<T> products) {
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
        
        public List<T> getProducts() {
            List<T> copy = new ArrayList<>(this.products);
            
            return copy;
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
    
    static <T> AlmostSafe.Order createOrder(User user, List<T> products) {
        return new AlmostSafe.Order(LocalDate.now(), user, products);
    }
    
    public static void main(String[] args) {
        User user = new User("Maaike", new Address(),  new SensitiveObject(123));
        
        List<String> products = new ArrayList<>();
        products.add("drinking bottle");
        
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product());
        
        AlmostSafe.Order order = createOrder(user, products);
        AlmostSafe.Order order1 = createOrder(user, products1);
        
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
        
        System.out.println("===Comparring original and copy===");
        System.out.println("List reference are same: " + order1.getProducts().equals(copy1));
        System.out.println("1st item reference are same: " + (order1.getProducts().get(0) == copy1.get(0)));
    }
}
