package enums;

public class Main {

    public static void main(String[] args) {
        MyEnum myEnumB = MyEnum.B;
        System.out.printf("myEnumB's weight = %d%n", myEnumB.getWeight());

        MyEnum myEnumA = MyEnum.A;
        System.out.printf("myEnumA's weight = %d%n", myEnumA.getWeight());
    }
}

enum MyEnum {
    A, B(2), C;

    private int weigh;

    // Enum constructor is implicitly private
    private MyEnum() {
        this.weigh = 0;
    }

    private MyEnum(int weigh) {
        this.weigh = weigh;
    }

    public int getWeight() {
        return weigh;
    }
}
