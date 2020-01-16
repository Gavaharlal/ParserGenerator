package calc;

public class CalcGrammarParser {
    private final CalcGrammarLexer lexer;

    public CalcGrammarParser(final CalcGrammarLexer lexer) {
        this.lexer = lexer;
    }

    public int mainRule() throws ParsingException, LexingException {
        lexer.nextToken();
        int res = parseE();
        if (lexer.getCurrentToken().type != CalcGrammarTokens._END) {
            throw new ParsingException("Expected end of input but found " + lexer.getCurrentToken().getText());
        }
        return res;
    }

    private int parseE() throws ParsingException, LexingException {
        int res;
        switch (lexer.getCurrentToken().type) {
            case LB:
            case NUM:
            case MINUS: {
                
                int t = parseT();
                
                int e_ = parseE_(t);
                res = e_;
                break;
            }
            default: {
                throw new ParsingException("Expected LB, NUM, MINUS but found " + lexer.getCurrentToken().type.name());
            }
        }
        return res;
    }

    private int parseE_(int acc) throws ParsingException, LexingException {
        int res;
        switch (lexer.getCurrentToken().type) {
            case PLUS: {
                
                
                lexer.nextToken();
                int t = parseT();
                int propAcc = acc + t;
                int e_ = parseE_(propAcc);
                res = e_;
                break;
            }
            case MINUS: {
                
                
                lexer.nextToken();
                int t = parseT();
                int propAcc = acc - t;
                int e_ = parseE_(propAcc);
                res = e_;
                break;
            }
            case _END:
            case RB: {
                res = acc;
                break;
            }
            default: {
                throw new ParsingException("Expected PLUS, MINUS, _END, RB but found " + lexer.getCurrentToken().type.name());
            }
        }
        return res;
    }

    private int parseT() throws ParsingException, LexingException {
        int res;
        switch (lexer.getCurrentToken().type) {
            case LB:
            case NUM:
            case MINUS: {
                
                int f = parseF();
                
                int t_ = parseT_(f);
                res = t_;
                break;
            }
            default: {
                throw new ParsingException("Expected LB, NUM, MINUS but found " + lexer.getCurrentToken().type.name());
            }
        }
        return res;
    }

    private int parseT_(int acc) throws ParsingException, LexingException {
        int res;
        switch (lexer.getCurrentToken().type) {
            case MUL: {
                
                
                lexer.nextToken();
                int f = parseF();
                int propAcc = acc * f;
                int t_ = parseT_(propAcc);
                res = t_;
                break;
            }
            case _END:
            case RB:
            case PLUS:
            case MINUS: {
                res = acc;
                break;
            }
            default: {
                throw new ParsingException("Expected MUL, _END, RB, PLUS, MINUS but found " + lexer.getCurrentToken().type.name());
            }
        }
        return res;
    }

    private int parseF() throws ParsingException, LexingException {
        int res;
        switch (lexer.getCurrentToken().type) {
            case LB: {
                
                
                lexer.nextToken();
                int e = parseE();
                
                res = e;
                lexer.nextToken();
                break;
            }
            case NUM: {
                
                Token num = lexer.getCurrentToken();
                res = Integer.parseInt(num.getText());
                lexer.nextToken();
                break;
            }
            case MINUS: {
                
                
                lexer.nextToken();
                int f = parseF();
                res = -1 * f;
                break;
            }
            default: {
                throw new ParsingException("Expected LB, NUM, MINUS but found " + lexer.getCurrentToken().type.name());
            }
        }
        return res;
    }

}
