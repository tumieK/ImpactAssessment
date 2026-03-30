package numberrangesummarizer;

import java.util.*;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        List<Integer> numbers = new ArrayList<>();

        if (input == null || input.trim().isEmpty()) {
            return numbers;
        }

        String[] parts = input.split(",");

        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                int num = Integer.parseInt(trimmed);
                if (!numbers.contains(num)) { // remove duplicates
                    numbers.add(num);
                }
            }
        }

        Collections.sort(numbers);
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        List<Integer> numbers = new ArrayList<>(input);
        Collections.sort(numbers);

        StringBuilder result = new StringBuilder();

        int start = numbers.get(0);
        int prev = start;

        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);

            if (current == prev + 1) {
                prev = current;
            } else {
                appendRange(result, start, prev);
                start = current;
                prev = current;
            }
        }

        appendRange(result, start, prev);

        return result.toString();
    }

    private void appendRange(StringBuilder result, int start, int end) {
        if (result.length() > 0) {
            result.append(", ");
        }

        if (start == end) {
            result.append(start);
        } else {
            result.append(start + "-" + end);
        }
    }
}