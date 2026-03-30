package numberrangesummarizer;

import org.junit.jupiter.api.Test;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerImplTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

    @Test
    void shouldSummarizeExampleCorrectly() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);

        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    @Test
    void shouldHandleSingleNumber() {
        String input = "5";

        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);

        assertEquals("5", result);
    }

    @Test
    void shouldHandleEmptyInput() {
        Collection<Integer> numbers = summarizer.collect("");
        String result = summarizer.summarizeCollection(numbers);

        assertEquals("", result);
    }

    @Test
    void shouldSortUnorderedInput() {
        String input = "5,1,2,3";

        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);

        assertEquals("1-3, 5", result);
    }

    @Test
    void shouldRemoveDuplicates() {
        String input = "1,2,2,3,4";

        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);

        assertEquals("1-4", result);
    }

    @Test
    void shouldHandleNonSequentialNumbers() {
        String input = "1,3,5,7";

        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);

        assertEquals("1, 3, 5, 7", result);
    }
    @Test
    void shouldHandleSpacesInInput() {
        String input = " 1, 2 , 3 ,4 ";

        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);

        assertEquals("1-4", result);
    }
}