package classdefandreachability;

import java.time.LocalDate;

/**
 * @author Rodney Taylor (u228616)
 */
public class BuildMe {
    private String name;
    private LocalDate date;
    
    private BuildMe() {}
    
    public static Builder builder() {
        return new Builder();
    }
    
    @Override
    public String toString() {
        return "BuildMe{" + "name='" + name + '\'' + ", date=" + date + '}';
    }
    
    public static class Builder {
        private BuildMe template = new BuildMe();
        
        private Builder() {}
        
        public Builder name(String name) {
            template.name = name;
            return this;
        }
        
        public Builder date(LocalDate date) {
            template.date = date;
            return this;
        }
        
        public BuildMe build() {
            BuildMe buildMe = template;
            template = null;
            return buildMe;
        }
    }
}

class TryBuilder {
    public static void main(String[] args) {
        BuildMe buildMe = BuildMe
                .builder()
                .name("Fred")
                .date(LocalDate.now())
                .build();
        
        System.out.println(buildMe);
        
    }
}
