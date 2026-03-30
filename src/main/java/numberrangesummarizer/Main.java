package numberrangesummarizer;

import numberrangesummarizer.NumberRangeSummarizer;
import numberrangesummarizer.NumberRangeSummarizerImpl;

import java.util.Collection;

import static java.lang.IO.println;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("1,3,6,7,8,12,13,14,15");

        String result = summarizer.summarizeCollection(numbers);

        println(result);

    }
}
