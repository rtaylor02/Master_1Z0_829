package textblocks;

/**
 * @author Rodney Taylor (u228616)
 */
public class Main {
    public static void main(String[] args) {
        String tb = """
                no space
                 one space
                  two spaces
                """;
        
        System.out.println(tb);

        tb = """
                 the \\n after the opening \""" is a MUST.
                 Otherwise it's CE\s""";

        System.out.println(tb);

        tb =
                """
                        This is weird
                        But it's possible and no CE... 
                        """;

        System.out.println(tb);

        tb = """
                Trailing white space is ignored 
                like above, except when there's escape char like now, \
                you see?
                Another escape char is \\t for a tab)\t\t\t\t\t (5 tabs just now),
                and \\s for a space: \s\s\s\s\s((1+)5 extra spaces just now)
                """;

        System.out.println(tb);
        System.out.println("This is a test for space character \s\s((1+)2 extra spaces just now)");

        System.out.println("=============");
        prepare();
    }

    private static String label(String title, String author) {
        return """
                Book: \n
                """ + title + " by " + author;
    }

    private static void prepare() {
        String labelled = label("""
                                    Java Study Guide \
                                    for Java 21
                                    2024 Edition""", "Jeanne and Scott");
        System.out.println(labelled);
    }
}
