package classdefandreachability;

public class Access {
    private String name = "Access";
    
    class A1 {
        private String name = "A1";
    }
    
    static class A2 {
        private String name = "A2";
        
        void show() {
            System.out.println(new Access().new A1().name);
            System.out.println(name); // Automatic this.name
        }
        
        void show(Access access) {
            System.out.println(access.new A1().name);
        }
        
        void show(A1 a1) {
            System.out.println(a1.name);
        }
    }
    
}

class Outsider {
    public static void main(String[] args) {
        Access.A2 a2 = new Access.A2();
        a2.show();
        a2.show(new Access());
        a2.show(new Access().new A1());
    }
}

