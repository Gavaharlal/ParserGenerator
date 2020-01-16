import calc.CalcGrammarLexer;
import calc.CalcGrammarParser;
import grammar.GrammarException;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, GrammarException {
//        Path grammarPath = Paths.get("CalcGrammar");
        Path grammarPath = Paths.get("RegExpsGrammar");
//        Path outputPath = Paths.get("generated\\calc");
        Path outputPath = Paths.get("C:\\Users\\Computer\\IdeaProjects\\RegExpsParser\\src\\parser");
//
        Generator.generate(grammarPath, outputPath);
//        Path input = Paths.get("testInput");
//
//        try {
//            CalcGrammarLexer lexer = new CalcGrammarLexer(CharStreams.fromPath(input).toString());
//            CalcGrammarParser parser = new CalcGrammarParser(lexer);
//            System.out.println(parser.mainRule());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
