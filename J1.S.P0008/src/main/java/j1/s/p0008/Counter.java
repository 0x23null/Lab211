package j1.s.p0008;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Counter {

    private final Map<String, Integer> wordCount = new TreeMap<>();
    private final Map<Character, Integer> charCount = new TreeMap<>();

    public void analyze(String content) {
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }

    public Map<Character, Integer> getCharCount() {
        return charCount;
    }
}
