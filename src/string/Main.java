package string;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        playWithStringMethods();
    }
    
    private static void playWithStringMethods() {
        String goal = "Java Developer %nin banking sector %d %n========================";
        
        System.out.println("original text = " + goal);
        
        String formattedGoal = goal.formatted(2023);
        System.out.println("formatted goal = " + formattedGoal);
        
        
        String indent = "indent me!";
        System.out.println("original: \n" + indent);
        System.out.print(indent.indent(1)); // 1 character indentation
        System.out.print(indent.indent(4)); // 4 character indentation
        System.out.print(indent.indent(12)); // 16 character indentation
        
        String stripIndent = "\t\t\tUnindent me!";
        System.out.println("original: \n" + stripIndent);
        System.out.println(stripIndent.stripIndent());
    }
}
