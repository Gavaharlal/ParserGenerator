package grammar;

import java.util.List;

public class ParserRule {
    private final String name;
    private final List<Variable> arguments;
    private final Variable returnValue;
    private final List<RuleOption> alternatives;

    public ParserRule(final String name, final List<Variable> arguments,
                      final Variable returnValue, final List<RuleOption> alternatives) {
        this.name = name;
        this.arguments = arguments;
        this.returnValue = returnValue;
        this.alternatives = alternatives;
    }

    public String getName() {
        return name;
    }

    public List<Variable> getArguments() {
        return arguments;
    }

    public Variable getReturnValue() {
        return returnValue;
    }

    public List<RuleOption> getAlternatives() {
        return alternatives;
    }
}
