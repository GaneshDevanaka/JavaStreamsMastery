import javax.swing.plaf.PanelUI;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExamples {
    public static List<Integer> getEvenNumbers() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNums = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        return evenNums;//output:-[2,4,6]
    }

    public static List<Integer> getNumbersGreaterthan25() {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);
        var listNumsGreaterthan25 = numbers.stream().filter(num -> num > 25).collect(Collectors.toList());
        return listNumsGreaterthan25;//output:-[30, 35, 40]
    }

    public static List<String> getUpperCase() {
        List<String> words = Arrays.asList("java", "streams", "rocks");
        var convertedStrings = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        return convertedStrings;//output:-[JAVA, STREAMS, ROCKS]
    }

    public static long getCountStringStartsWithG() {
        List<String> names = Arrays.asList("Ganesh", "Gaurav", "Geeta", "Ravi", "Anita");
        long countStringsStartsWithG = names.stream().
                filter(name -> name.startsWith("G")).count();
        return countStringsStartsWithG;//output:- 3
    }

    public static String getLongestStringInList() {
        List<String> words = Arrays.asList("Java", "Spring", "Boot", "Stream", "API");
        Optional<String> longestString = words.stream().max(Comparator.comparingInt(String::length));
        return longestString.orElse("");//output:-Spring
    }

    public static List<Integer> flatNestedList() {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6)
        );
        List<Integer> flatNestedList = nestedList.stream().flatMap(num -> num.stream()).distinct().collect(Collectors.toList());
        return flatNestedList;//output:-[1, 2, 3, 4, 5, 6]
    }

    public static Map<Character, List<String>> groupByFirsChar() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry", "avocado");
        Map<Character, List<String>> listgroupByFirsChar = words.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        return listgroupByFirsChar;//output:-{a=[apple, apricot, avocado], b=[banana, blueberry], c=[cherry]}
    }

    public static String getCommaSepartedString() {
        List<String> words = Arrays.asList("Java", "is", "very", "powerful", "and", "popular");
        String commaSeperatedString = words.stream().filter(word -> word.length() > 3).collect(Collectors.joining(","));
        return commaSeperatedString;//output:-Java,very,powerful,popular
    }

    public static Map<String, Long> countOfStrings() {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        var countOfStringInList = fruits.stream().collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()));
        return countOfStringInList;//output;-{orange=1, banana=2, apple=3}
    }

    public static List<String> top3LongestStrings() {
        List<String> names = Arrays.asList("Christopher", "Alex", "John", "Elizabeth", "Mark", "Charlotte");
        var top3LongestStringsInList = names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3).collect(Collectors.toList());
        return top3LongestStringsInList;//output:-[Christopher, Elizabeth, Charlotte]
    }

    public static Map<Boolean, List<Integer>> partitionEvenOdd() {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 15);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        return partitioned;//output:-{false=[9, 13, 15], true=[12, 4, 6, 2]}
    }

    public List<String> listOfDuplicate(){
        List<String> names = Arrays.asList("Ganesh", "John", "Alice", "Ganesh", "Alice", "Mark", "Bob");
        var listOfDuplicateStrings=names.stream().
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()>1).map(x->x.getKey()).collect(Collectors.toList());
        return listOfDuplicateStrings;//output:-[Ganesh, Alice]
    }

    public List<String> getwordsfromSentences(){
        List<String> sentences = Arrays.asList(
                "Java is awesome",
                "Streams are powerful",
                "Practice makes perfect"
        );
        List<String> wordsfromSentences=sentences.stream().
                map(sentence->sentence.split(" ")).flatMap(x-> Arrays.stream(x).sequential()).collect(Collectors.toList());
        return wordsfromSentences;//output:-[Java, is, awesome, Streams, are, powerful, Practice, makes, perfect]
    }
    public String mostFrequentString(){
        List<String> logs = Arrays.asList("INFO", "ERROR", "INFO", "WARN", "ERROR", "ERROR", "DEBUG");
        var mostFrequentString=logs.stream().collect(Collectors.
                groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).toString();
        return mostFrequentString;//output Optional[ERROR=3]

    }


}



