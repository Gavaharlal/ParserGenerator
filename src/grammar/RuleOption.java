package grammar;

import java.util.ArrayList;
import java.util.List;

public class RuleOption {
    private final String initCode;
    private final List<RuleAtom> atoms;

    private final boolean isEpsilonRule;

    public RuleOption(final String initCode, final List<RuleAtom> atoms) {
        if (initCode == null) {
            this.initCode = "";
        } else {
            int codeLen = initCode.length();
            this.initCode = initCode.substring(1, codeLen - 1);
        }
        this.atoms = atoms;
        isEpsilonRule = atoms.isEmpty();
    }

    public String getInitCode() {
        return initCode;
    }

    public List<RuleAtom> getAtoms() {
        return atoms;
    }

    public boolean isEpsilonRule() {
        return isEpsilonRule;
    }
}
