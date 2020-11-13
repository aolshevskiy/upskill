package upskill;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlLexicalAnalyzer {
    private static final Pattern pattern = Pattern.compile("(</[^>]+>)|(<[^>]+/>)|(<[^>]+>)|([^<]+)");

    public static List<Tag> parse(String contents) {
        Matcher matcher = pattern.matcher(contents);

        List<Tag> tags = new ArrayList<>();

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tags.add(new Tag("closing", matcher.group(1)));
            } else if (matcher.group(2) != null) {
                tags.add(new Tag("no body tag", matcher.group(2)));
            } else if (matcher.group(3) != null) {
                tags.add(new Tag("opening", matcher.group(3)));
            } else if (matcher.group(4) != null && !matcher.group(4).trim().isEmpty()) {
                tags.add(new Tag("content", matcher.group(4)));
            }
        }

        return tags;
    }

    public static class Tag {
        private final String type;
        private final String content;

        public Tag(String type, String content) {
            this.type = type;
            this.content = content;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Tag.class.getSimpleName() + "[", "]")
                    .add("type='" + type + "'")
                    .add("content='" + content + "'")
                    .toString();
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = XmlLexicalAnalyzer.class.getResourceAsStream("/sample.xml");
        List<Tag> tags = parse(new String(inputStream.readAllBytes()));
        tags.forEach(System.out::println);
    }
}
