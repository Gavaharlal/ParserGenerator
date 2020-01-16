import generators.LexerGenerator;
import generators.ParserGenerator;
import generators.TabbedWriter;
import grammar.Grammar;
import grammar.GrammarException;
import grammarparsing.GrammarLexer;
import grammarparsing.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Generator {

    public static void generate(Path grammarPath, Path outputPath) throws IOException, GrammarException {
        GrammarLexer lexer;
        lexer = new GrammarLexer(CharStreams.fromPath(grammarPath));
        GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));
        Grammar grammar = parser.grammarDescription().descr;
        if (grammar.getGrammarException() != null) throw grammar.getGrammarException();
        Files.createDirectories(outputPath);
        copyExceptions(outputPath, grammar.getHeader());
        String name = grammarPath.getName(grammarPath.getNameCount() - 1).toString();
        LexerGenerator lexerGenerator = new LexerGenerator(outputPath, name, grammar);
        lexerGenerator.generate();
        ParserGenerator parserGenerator = new ParserGenerator(outputPath, name, grammar);
        parserGenerator.generate();
    }

    private static void copyExceptions(Path output, String header) throws IOException {
        Path outputLexingException = output.resolve("LexingException.java");
        try (TabbedWriter out = new TabbedWriter(outputLexingException)) {
            out.writeHeader(header);
            out.println(0, "public class LexingException extends Exception {");
            out.println(1, "public LexingException(final String description) {");
            out.println(2, "super(description);");
            out.println(1, "}");
            out.println(0, "}");
        }

        Path outputParsingException = output.resolve("ParsingException.java");
        try (TabbedWriter out = new TabbedWriter(outputParsingException)) {
            out.writeHeader(header);
            out.println(0, "public class ParsingException extends Exception {");
            out.println(1, "public ParsingException(final String description) {");
            out.println(2, "super(description);");
            out.println(1, "}");
            out.println(0, "}");
        }
    }
}
