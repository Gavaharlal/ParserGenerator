package grammar;

public class Terminal extends RuleAtom {
    public Terminal(final String var, final String name, final String afterCode) {
        super(var, name, afterCode);
    }

    @Override
    public boolean isTerminal() {
        return true;
    }
}
