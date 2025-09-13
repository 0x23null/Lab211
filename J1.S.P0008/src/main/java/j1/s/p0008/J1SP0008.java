package j1.s.p0008;

public class J1SP0008 {

    public static void main(String[] args) {
        String content = Inputter.getString("Enter your content: ");

        Counter counter = new Counter();
        counter.analyze(content);

        System.out.println(counter.getWordCount());
        System.out.println(counter.getCharCount());
    }
}
