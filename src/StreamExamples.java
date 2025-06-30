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
        var mostFrequentString=logs.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(x->x.getKey()) // .map(Map.Entry::getKey)
                .orElse("");
        return mostFrequentString;//output Optional[ERROR=3]

    }
    public static  List<String> listOfCitiesSortedByFrequency(){
        List<String> cities = Arrays.asList(
                "Mumbai", "Delhi", "Bangalore", "Chennai", "Kolkata", "Delhi", "Mumbai", "Mumbai", "Chennai"
        );
        List<String> listOfCitiesSortedByFrequency=cities.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).map(Map.Entry::getKey).collect(Collectors.toList());
        return listOfCitiesSortedByFrequency;//output [Mumbai, Delhi, Chennai, Kolkata, Bangalore]
    }
    List<Employee> employees = Arrays.asList(
            new Employee("Ganesh", "IT"),
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("John", "Finance"),
            new Employee("Eve", "HR")
    );
    public Map<String,List<String>> groupingEmployeesByDepartment() {

        Map<String,List<String>> groupingEmployeesByDepartment=employees.stream().collect(Collectors.
                groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
        return  groupingEmployeesByDepartment;//output {Finance=[John], HR=[Alice, Eve], IT=[Ganesh, Bob]}

    }
    public Map<Boolean,List<String>> partioningEmployeesByDepartment() {
        Map<Boolean,List<String>> partioningEmployeesByDepartment=employees.stream().
                collect(Collectors.partitioningBy(emp->emp.getDepartment().equals("IT"),Collectors.mapping(Employee::getName,Collectors.toList())));
        return  partioningEmployeesByDepartment;//output {false=[Alice, John, Eve], true=[Ganesh, Bob]}
    }

    public Map<String,List<String>> groupingAndFilteringEmployeesByDepartment() {

        Map<String,List<String>> groupingAndFilteringEmployeesByDepartment=employees.stream().filter(emp-> emp.getName().startsWith("G") || emp.getName().startsWith("J")).
                collect(Collectors.
                groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
        return  groupingAndFilteringEmployeesByDepartment;//output {Finance=[John], IT=[Ganesh]}}

    }
    public static Integer reduceProductOfNumbers(){
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 9);
        Integer reduceProductOfNumbers=numbers.stream().reduce(1,(x,y)->x*y);
        return reduceProductOfNumbers;// OUTPUT 1890
    }

    public static OptionalDouble averageLengt0fAllWords(){
        List<String> words = Arrays.asList("Streams", "are", "very", "powerful", "and", "fun");
            OptionalDouble averageLengt0fAllWords=words.stream().mapToInt(String::length).average();
            return averageLengt0fAllWords;// OUTPUT OptionalDouble[4.666666666666667]
    }

    public static IntSummaryStatistics  summaryStatistics(){
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        IntSummaryStatistics summaryStatistics=numbers.stream().mapToInt(x->x).summaryStatistics();
        return summaryStatistics;// OUTPUT IntSummaryStatistics{count=5, sum=150, min=10, average=30.000000, max=50}
    }

    public static List<String>  peekBeforeFiltering(){
        List<String> words = Arrays.asList("Java", "Stream", "API", "Power", "Debug");
        List<String> peekBeforeFiltering=words.stream()
                .peek(word -> System.out.println("Before filter: " + word))  .filter(x->x.length()>4).peek(word -> System.out.println("After filter: " + word))  .collect(Collectors.toList());
        return peekBeforeFiltering;// OUTPUT IntSummaryStatistics{count=5, sum=150, min=10, average=30.000000, max=50}
    }





}



