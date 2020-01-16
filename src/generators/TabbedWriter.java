package generators;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class TabbedWriter implements Closeable {
    private final static String TAB = "    ";
    private final Writer writer;

    public TabbedWriter(final Path path) throws IOException {
        this.writer = Files.newBufferedWriter(path);
    }

    public void println(int tabsNumber, final String s) throws IOException {
        print(tabsNumber, s);
        writer.write('\n');
    }

    public void print(int tabsNumber, final String s) throws IOException {
        writeTabs(tabsNumber);
        writer.write(s);
    }

    private void writeTabs(int num) throws IOException {
        for (int i = 0; i < num; ++i) {
            writer.write(TAB);
        }
    }

    public void writeHeader(String header) throws IOException {
        header = header.substring(1);
        header = header.substring(0, header.length() - 1);
        writer.write(header.trim() + "\n\n");
    }

    public void writeFunctionHead(String modifier, String retType, String name, String args) throws IOException {
        println(1, modifier + " " + retType + " " + name + "(" + args + ") throws ParsingException, LexingException {");
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
