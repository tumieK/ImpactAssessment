package numberrangesummarizer;

import java.util.*;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer{
    @Override
    public Collection<Integer> collect(String input) {
        if(input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if(input == null || input.isEmpty()){
            return "";
        }
        List<Integer> numbers = new ArrayList<>(input);
        Collections.sort(numbers);

        StringBuilder result = new StringBuilder();

        int start = numbers.getFirst();
        int prev = start;

        for(int i=1; i< numbers.size();i++){
            int current = numbers.get(i);

            if(current == prev + 1){
                prev = current;
            }
            else{
                appendRange(result,start,prev);
                start =current;
                prev = current;
            }
        }
        appendRange(result, start, prev);
        return  result.toString();
    }
    private void appendRange(StringBuilder result, int start, int end) {
        if (!result.isEmpty()) {
            result.append(", ");
        }

        if (start == end) {
            result.append(start);
        } else {
            result.append(start).append("-").append(end);
        }
    }

}
