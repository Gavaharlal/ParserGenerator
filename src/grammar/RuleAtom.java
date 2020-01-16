package grammar;

abstract public class RuleAtom {
    private final String var;
    private final String ruleSignature;
    private final String code;

    public RuleAtom(final String var, final String ruleSignature, final String afterCode) {
        this.var = var;
        this.ruleSignature = ruleSignature;
        this.code = afterCode == null ? "" : afterCode.substring(1, afterCode.length() - 1);
    }

    public abstract boolean isTerminal();

    public String getCode() {
        return code;
    }

    public String getRuleSignature() {
        return ruleSignature;
    }

    public String getVar() {
        return var;
    }
}
