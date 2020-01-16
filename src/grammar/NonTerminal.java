package grammar;

import java.util.List;

public class NonTerminal extends RuleAtom {
    private final List<String> params;

    public NonTerminal(final String var, final String name, final List<String> params, final String afterCode) {
        super(var, name, afterCode);
        this.params = params;
    }

    public List<String> getParams() {
        return params;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }
}
