package grammar;

public class Variable {
    private final String type;
    private final String name;

    public Variable(final String type, final String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}