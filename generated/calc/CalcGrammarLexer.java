package calc;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcGrammarLexer {
    private final Pattern ignorePattern;
    private CharSequence inputCharSequence;
    private final Map<CalcGrammarTokens, Pattern> tokens;
    private Token currentToken;

    public CalcGrammarLexer(CharSequence input) {
        ignorePattern = Pattern.compile(" ");
        inputCharSequence = input;
        this.tokens = new HashMap<>();
        tokens.put(CalcGrammarTokens.PLUS, Pattern.compile("\\+"));
        tokens.put(CalcGrammarTokens.MINUS, Pattern.compile("-"));
        tokens.put(CalcGrammarTokens.MUL, Pattern.compile("\\*"));
        tokens.put(CalcGrammarTokens.LB, Pattern.compile("\\("));
        tokens.put(CalcGrammarTokens.RB, Pattern.compile("\\)"));
        tokens.put(CalcGrammarTokens.NUM, Pattern.compile("([1-9][0-9]*)|0"));
    }

    public Token getCurrentToken() {
        return currentToken;
    }

    public void nextToken() throws LexingException {
        Matcher matcher = ignorePattern.matcher(inputCharSequence);
        while (matcher.lookingAt()) {
            inputCharSequence = inputCharSequence.subSequence(matcher.end(), inputCharSequence.length());
            matcher.reset(inputCharSequence);
        }

        for (CalcGrammarTokens token : CalcGrammarTokens.values()) {
            if (token == CalcGrammarTokens._END) continue;
            Pattern tokenPattern = tokens.get(token);
            matcher = tokenPattern.matcher(inputCharSequence);
            if (matcher.lookingAt()) {
                String curMatch = inputCharSequence.subSequence(0, matcher.end()).toString();
                inputCharSequence = inputCharSequence.subSequence(curMatch.length(), inputCharSequence.length());
                currentToken = new Token(token, curMatch);
                return;
            }
        }

        if (inputCharSequence.length() == 0) {
            currentToken = new Token(CalcGrammarTokens._END, "END");
        } else {
            throw new LexingException("Unmatched data in input: \"" + inputCharSequence + "\"");
        }
    }
}
