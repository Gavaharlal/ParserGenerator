package calc;

public class Token {
    public final CalcGrammarTokens type;
    private final String text;

    public Token(final CalcGrammarTokens type, final String text) {
        this.type = type;
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
