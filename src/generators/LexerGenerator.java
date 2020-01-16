package generators;

import grammar.Grammar;
import grammar.TokenRule;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


public class LexerGenerator {
    private final Path output;
    private final String name;
    private final Grammar grammar;

    public LexerGenerator(final Path output, final String name, final Grammar grammar) {
        this.output = output;
        this.name = name;
        this.grammar = grammar;
    }

    public void generate() throws IOException {
        generateTokens();
        generateLexer();
    }

    private void generateTokens() throws IOException {
        try (TabbedWriter writer = new TabbedWriter(output.resolve(name + "Tokens.java"))) {
            writer.writeHeader(grammar.getHeader());
            writer.println(0, "public enum " + name + "Tokens {");
            String tokens = grammar.getTokenRules().stream()
                    .map(TokenRule::getName)
                    .collect(Collectors.joining(", "));
            writer.println(1, tokens + ", " + Grammar.END + ";}");
        }
        try (final TabbedWriter writer = new TabbedWriter(output.resolve("Token.java"))) {
            writer.writeHeader(grammar.getHeader());
            writer.println(0, "public class Token {");
            writer.println(1, "public final " + name + "Tokens type;");
            writer.println(1, "private final String text;\n");
            writer.println(1, "public Token(final " + name + "Tokens type, final String text) {");
            writer.println(2, "this.type = type;");
            writer.println(2, "this.text = text;");
            writer.println(1, "}");
            writer.println(0, "");
            writer.println(1, "public String getText() {");
            writer.println(2, "return text;");
            writer.println(1, "}");
            writer.println(0, "}");
        }
    }

    private void generateLexer() throws IOException {
        final String tokensName = name + "Tokens";
        try (TabbedWriter writer = new TabbedWriter(output.resolve(name + "Lexer.java"))) {
            writer.writeHeader(grammar.getHeader());
            writer.println(0, "import java.util.HashMap;");
            writer.println(0, "import java.util.Map;");
            writer.println(0, "import java.util.regex.Matcher;");
            writer.println(0, "import java.util.regex.Pattern;\n");
            writer.println(0, "public class " + name + "Lexer {");
            writer.println(1, "private final Pattern ignorePattern;");
            writer.println(1, "private CharSequence inputCharSequence;");
            writer.println(1, "private final Map<" + tokensName + ", Pattern> tokens;");
            writer.println(1, "private Token currentToken;\n");
            writer.println(1, "public " + name + "Lexer(CharSequence input) {");

            List<TokenRule> tokens = grammar.getTokenRules();

            writer.println(2, "ignorePattern = Pattern.compile(" + grammar.getSkipRegex() + ");");
            writer.println(2, "inputCharSequence = input;");
            writer.println(2, "this.tokens = new HashMap<>();");
            for (TokenRule tokenRule : tokens) {
                writer.println(2, "tokens.put(" + tokensName + "." + tokenRule.getName() + ", Pattern.compile(" + tokenRule.getRegex() + "));");
            }
            writer.println(1, "}\n");

            writer.println(1, "public Token getCurrentToken() {");
            writer.println(2, "return currentToken;");
            writer.println(1, "}\n");

            writer.println(1, "public void nextToken() throws LexingException {");
            writer.println(2, "Matcher matcher = ignorePattern.matcher(inputCharSequence);");
            writer.println(2, "while (matcher.lookingAt()) {");
            writer.println(3, "inputCharSequence = inputCharSequence.subSequence(matcher.end(), inputCharSequence.length());");
            writer.println(3, "matcher.reset(inputCharSequence);");
            writer.println(2, "}\n");
            writer.println(2, "for (" + tokensName + " token : " + tokensName + ".values()) {");
            writer.println(3, "if (token == " + tokensName + "._END) continue;");
            writer.println(3, "Pattern tokenPattern = tokens.get(token);");
            writer.println(3, "matcher = tokenPattern.matcher(inputCharSequence);");
            writer.println(3, "if (matcher.lookingAt()) {");
            writer.println(4, "String curMatch = inputCharSequence.subSequence(0, matcher.end()).toString();");
            writer.println(4, "inputCharSequence = inputCharSequence.subSequence(curMatch.length(), inputCharSequence.length());");
            writer.println(4, "currentToken = new Token(token, curMatch);");
            writer.println(4, "return;");
            writer.println(3, "}");
            writer.println(2, "}\n");
            writer.println(2, "if (inputCharSequence.length() == 0) {");
            writer.println(3, "currentToken = new Token(" + tokensName + "._END, \"END\");");
            writer.println(2, "} else {");
            writer.println(3, "throw new LexingException(\"Unmatched data in input: \\\"\" + inputCharSequence + \"\\\"\");");
            writer.println(2, "}");
            writer.println(1, "}");
            writer.println(0, "}");
        }
    }
}
