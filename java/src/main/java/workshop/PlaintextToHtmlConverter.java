package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    String source;
    int i;
    List<String> result;
    List<String> convertedLine;
    String characterToConvert;

    public String toHtml() throws Exception {
        return basicHtmlEncode(read());
    }

    protected String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }

    private String basicHtmlEncode(String source) {
        result = new ArrayList<>();
        convertedLine = new ArrayList<>();
        convertToCode(source);
        addANewLine();
        return String.join("<br />", result);
    }
    public void convertToCode(String source)
    {
        this.source = source;
        i=0;
        characterToConvert= String.valueOf(source.charAt(i));
        while (i <= this.source.length()) {
            switch (characterToConvert) {
                case "<":
                    convertedLine.add("&lt;");
                    break;
                case ">":
                    convertedLine.add("&gt;");
                    break;
                case "&":
                    convertedLine.add("&amp;");
                    break;
                case "\n":
                    addANewLine();
                    break;
                default:
                    addCharacterToConvert();
            }
            characterToConvert= collectCharacterAndIncrementPointer();
            i++;
        }
    }
    private String collectCharacterAndIncrementPointer() {
        char c = source.charAt(i);
        i += 1;
        return String.valueOf(c);
    }
    private void addANewLine() {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }
    private void addCharacterToConvert() {
        convertedLine.add(characterToConvert);
    }
}



